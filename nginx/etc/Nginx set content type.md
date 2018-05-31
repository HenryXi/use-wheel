# Nginx set content type
Nginx will add `Content-Type` depend on suffix of url in response header. The mapping of suffix and `Content-Type` is in
`/etc/nginx/mime.types`. There are two ways to change `Content-Type` in Nginx.

**1. edit `mime.types` to map suffix and `Content-Type`**

Add a record in `mime.types` like following. All `Content-Type` of "*.video" url will be "video/mp4" 
```
video/mp4                             video; 
```

**2. add `default_type` in special location configuration**

Add `default_type` to appoint default `Content-Type` for current url. All `Content-Type` of "/video" url will be "video/mp4" 
```
location /video {
    root /video_file;
    index  index.html;
    default_type video/mp4;
}
```

EOF