### [node.js](https://nodejs.org)

`node -v` -> version

#### Node Version Manager [nvm](https://github.com/nvm-sh/nvm)

Bash script to manage multiple versions of node.js

* `nvm list` - list packages
* `nvm list-remote --lts` - list remote available packages
* `nvm install <version>` - install a specific version
  * `nvm install lts/*` - install the latest lts version
* `nvm use <version>` - use a specific version
* `nvm use system` - use the system installed version (i.e. a version not managed by nvm)
* `nvm install node --reinstall-packages-from=node` - install/upgrade the newest version
*  `nvm install-latest-npm` - install latest npm
* `nvm alias default <version>` - set the default version

##### Node versions

* `nvm install lts/erbium` - install node v12
* `nvm install lts/fermium` - install node v14

#### [.nvmrc](https://github.com/nvm-sh/nvm#nvmrc)

Content of `.nvmrc`:

* `lts/erbium` -> node v12
* `lts/fermium`-> node v14
