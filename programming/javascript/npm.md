### [npm](https://docs.npmjs.com/)

Javascript package manager. The default package manager for node.js.

* `npm install <name> -E` - npm install exact version
* `npm install <name> -E -D` - npm exact dependency for development
* `npm list -g --depth=0` - list globally installed packages
* `npm install npm@latest -g` - upgrade npm to the latest version

#### [ncu](https://www.npmjs.com/package/npm-check-updates) - npm-check-updates

npm tool for checking and performing dependency upgrades

* `npx npm-check-updates -t patch` - list packages that can have their patch version bumped (`target patch`)
  * add `-u` flag to apply the upgrades instead of just listing
* `npx npm-check-updates <package> <package>` - list upgrades for specified packages. Wildcards are supported - e.g. `nestjs-*`
  * add `-u` flag to apply the upgrades instead of just listing
