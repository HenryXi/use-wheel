package com.henryxi.gson;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author jackie chen
 * @create 4/16/20
 * @description JsonUtil
 */
public class JsonUtil {

    private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new LongDateTypeAdapter()).create();
    private static JsonParser parser = new JsonParser();

    /**
     * 解析string to {@link JsonObject}
     *
     * @param jsonStr json串
     * @return {@link JsonObject}
     */
    public static JsonObject parseObject(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        return parser.parse(jsonStr).getAsJsonObject();
    }

    /**
     * 解析 string to Object
     *
     * @param jsonStr json串
     * @param clazz   target Object class
     * @param <T>     泛型
     * @return Object
     */
    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }

    /**
     * 解析 string to Object
     *
     * @param jsonStr json串
     * @param type    target Object Type. <p>当前方法提供了type工具方法 {@link JsonUtil#getType(Type, Type...)} {@link JsonUtil#getMultiArgsType(Type, Type...)} </p>
     * @param <T>     泛型
     * @return Object
     */
    public static <T> T parseObject(String jsonStr, Type type) {
        return gson.fromJson(jsonStr, type);
    }

    /**
     * 解析 string to List<Object>
     *
     * @param jsonStr json串
     * @param clazz   target Object class
     * @param <T>     泛型
     * @return List<Object>
     */
    public static <T> List<T> parseObjectList(String jsonStr, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(List.class, clazz);
        return gson.fromJson(jsonStr, type);
    }

    /**
     * 解析 string to Map<Key,Value>
     *
     * @param jsonStr    json串
     * @param keyClazz   target Key class
     * @param valueClazz target Value class
     * @param <K>        key泛型
     * @param <V>        value泛型
     * @return Map<Key ,   Value>
     */
    public static <K, V> Map<K, V> parseObjectMap(String jsonStr, Class<K> keyClazz, Class<V> valueClazz) {
        Type type = ParameterizedTypeImpl.getMultiArgsParameterized(Map.class, keyClazz, valueClazz);
        return gson.fromJson(jsonStr, type);
    }

    /**
     * 解析 string to  {@link JsonArray}
     *
     * @param jsonStr json串
     * @return {@link JsonArray}
     */
    public static JsonArray parseArray(String jsonStr) {
        if (null == jsonStr) {
            return null;
        }
        return parser.parse(jsonStr).getAsJsonArray();
    }

    /**
     * Object to json串
     *
     * @param object Object
     * @return json串
     */
    public static String toJsonString(Object object) {
        return gson.toJsonTree(object).toString();
    }

    /**
     * 构建单参数的泛型Type
     * <p>
     * 例: 构建 Response<List<Student>>
     * JsonUtil.getType(Response.class, List.class, Student.class)
     * </p>
     * <p>
     * 如果是想构建嵌套类型
     * 例: List<Map<Integer, Student>
     * JsonUtil.getType(List.class, JsonUtil.getMultiArgsType(Map.class, Integer.class, Student.class))
     * </p>
     *
     * @param raw   当前类真实类型
     * @param types 嵌套泛型类
     * @return 单参数的泛型Type
     */
    public static Type getType(Type raw, Type... types) {
        return ParameterizedTypeImpl.get(raw, types);
    }

    /**
     * 构建多参数泛型Type
     * <p>
     * 例: 构建Map<Integer, String>
     * JsonUtil.getMultiArgsType(Map.class, Integer.class, String.class);
     * </p>
     * <p>
     * 如果是想构建嵌套类型
     * 例: Response<String, List<Student>>
     * JsonUtil.getMultiArgsType(Response.class, String.class, JsonUtil.getType(List.class, Student.class))
     * </p>
     * <p>
     * 构建只嵌套一层的单参数泛型Type也可使用该方法, 但不推荐使用, 此时建议使用{@link JsonUtil#getType(Type, Type...)}
     * 例: List<Student>可以使用JsonUtil.getMultiArgsType(List.class, Student.class)构造
     * </p>
     *
     * @param raw  当前类真实类型
     * @param args 泛型参数
     * @return 多参数泛型type
     */
    public static Type getMultiArgsType(Type raw, Type... args) {
        return ParameterizedTypeImpl.getMultiArgsParameterized(raw, args);
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        private final Type raw;
        private final Type owner;
        private final Type[] args;

        private ParameterizedTypeImpl(Type raw, Type singleArg) {
            this(null, raw, singleArg);
        }

        private ParameterizedTypeImpl(Type owner, Type raw, Type... args) {
            this.owner = owner;
            this.raw = raw;
            this.args = args;
        }

        public static ParameterizedTypeImpl get(Type rawType, Type... types) {
            final int length = types.length;
            if (length > 1) {
                Type parameterizedType = new ParameterizedTypeImpl(types[length - 2], types[length - 1]);
                Type[] newTypes = Arrays.copyOf(types, length - 1);
                newTypes[newTypes.length - 1] = parameterizedType;
                return get(rawType, newTypes);
            }
            return new ParameterizedTypeImpl(rawType, types[0]);
        }

        private static ParameterizedTypeImpl getMultiArgsParameterized(Type raw, Type... args) {
            return new ParameterizedTypeImpl(null, raw, args);
        }

        @Override
        public Type[] getActualTypeArguments() {
            return args;
        }

        @Override
        public Type getRawType() {
            return raw;
        }

        @Override
        public Type getOwnerType() {
            return owner;
        }
    }

    private static class LongDateTypeAdapter extends TypeAdapter<Date> {

        @Override
        public void write(JsonWriter jsonWriter, Date date) throws IOException {
            if (Objects.isNull(date)) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.value(date.getTime());
        }

        @Override
        public Date read(JsonReader jsonReader) throws IOException {
            if (Objects.isNull(jsonReader)) {
                return null;
            }
            return new Date(Long.parseLong(jsonReader.nextString()));
        }
    }
}
