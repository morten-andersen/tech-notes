### Bash tools for checking projects

#### Find version information of a used dependency (`package.json`)

Replace `<dependency-name>` with e.g. `typescript`

```bash
find . -path '*/node_modules' -prune -o -path '*/dist' -prune -o -type f -name 'package.json' -print0 | xargs -0 grep '"<dependency-name>"'
```

#### Find information about a setting in `tsconfig.json`

Replace `<option>` with e.g. `module` or `target`

```bash
find . -path '*/node_modules' -prune -o -path '*/dist' -prune -o -type f -name 'tsconfig.json' -print0 | xargs -0 grep '"<option>"'
```

#### Find bad imports of non-exported code from `/build/``

```bash
find . -path '*/node_modules' -prune -o -type f -name '*.ts' -print0 | xargs -0 grep '/build/'
```
