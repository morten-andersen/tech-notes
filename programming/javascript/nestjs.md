### NestJS

Running the nestjs binary without installing it globally

```bash
npx -p @nestjs/cli nest
```

#### Setup

```bash
npx -p @nestjs/cli nest new <app name>
```

##### Running the [CLI](https://docs.nestjs.com/cli/overview)

```bash
npx nest <command> <arguments>
```


#### Swagger documentation

https://docs.nestjs.com/openapi/introduction

```bash
npm install @nestjs/swagger swagger-ui-express
```

Setup CLI plugin
https://docs.nestjs.com/openapi/cli-plugin

#### Validation

https://docs.nestjs.com/techniques/validation

```bash
npm install class-validator class-transformer
npm install reflect-metadata --save
```

Add `app.useGlobalPipes(new ValidationPipe({transform: true}));`

uses class-validator https://github.com/typestack/class-validator

#### Logging

https://stackoverflow.com/questions/54101926/nestjs-middleware-get-request-response-body

#### [Documentation](https://docs.nestjs.com/recipes/documentation) for the project

Install

```bash
npm i -D @compodoc/compodoc
```

npm script command:

```
"doc": "compodoc -p tsconfig.json -s"
```

Generate and serve documentation from port 8080

```bash
npm run doc
```

#### Curl

```bash
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"orderNo": "3333", "customer": {"name": "benno","age":22}, "items": [{"name": "item1", "price": 27}, {"name": "item2", "price": 99}]}' \
  http://localhost:3000/

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"orderNo": "3333", "customer": {"name": "benno","age":22}, "items": [{"name": "item1", "price": 27, "frameSize": 55}, {"name": "item2", "price": 99, "frameSize": 45}]}' \
  http://localhost:3000/

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"orderNo": "3333", "customer": {"name": "benno","age":22}, "items": [{"name": "item1", "price": 27, "size": "medium"}, {"name": "item2", "price": 99, "size": "medium"}]}' \
  http://localhost:3001/
```
