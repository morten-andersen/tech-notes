### curl - for url requests

#### Basic auth

base64 auth:

```bash
echo -n <user>:<password> | base64
```

```bash
curl -H "Authorization: Basic dGVzdDpwYXNz" http://...
```
