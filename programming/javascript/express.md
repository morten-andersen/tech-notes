### Express - Web Framework

[Express](https://expressjs.com/)

#### Installing

```
npm install -E express
npm install -D -E @types/express
```

#### Simple server

* serving static files from the `public` folder
* replies to a GET on `/rest` endpoint

```javascript
import express from 'express';

const app = express();
const PORT = 8000;
app.use(express.static('public'))
app.get('/rest', (_req, res) => res.send('Express + TypeScript Server'));
app.listen(PORT, () => {
    console.log(`⚡️[server]: Server is running at http://localhost:${PORT}`);
});
```
