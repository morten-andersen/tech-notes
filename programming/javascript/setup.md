## TypeScript - Setup

### init new project

```
mkdir <project>
cd <project>
npm init
npm install -E -D typescript ts-node-dev @types/node
npm install -E -D eslint eslint-plugin-node
npm install -E -D jest ts-jest @types/jest
npm install -E -D rimraf
npx tsc --init
```

#### `tsconfig` settings

##### node v12

See [tsconfig-node12.json](./tsconfig-node12.json)

Described in StackOverflow [TypeScript tsconfig settings for Node.js 12?](https://stackoverflow.com/questions/59787574/typescript-tsconfig-settings-for-node-js-12/59787575#59787575)

##### node v14

See [tsconfig-node14.json](./tsconfig-node14.json)

Besides the settings in `tsconfig` it is also necessary to add `type: module` in `package.json` to use ES2020 module loading.

Described in StackOverflow [What TypeScript configuration produces output closest to Node.js 14 capabilities?](https://stackoverflow.com/questions/61305578/what-typescript-configuration-produces-output-closest-to-node-js-14-capabilities/61305579#61305579)

### Export types

[The 30-second guide to publishing a TypeScript package to NPM](https://cameronnokes.com/blog/the-30-second-guide-to-publishing-a-typescript-package-to-npm/)
