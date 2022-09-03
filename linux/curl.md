### [curl](https://curl.se/) - for url requests

#### Basic auth

base64 auth:

```bash
echo -n <user>:<password> | base64
```

```bash
curl -H "Authorization: Basic dGVzdDpwYXNz" http://...
```

#### Curl post

```
curl -d '{"key1":"value1", "key2":"value2"}' -H "Content-Type: application/json" -X POST http://..
```
