## Working with `JSON` from TypeScript

### [Loading JSON from a file](https://www.codevscolor.com/import-json-typescript)

Loading JSON from a file can be done statically like

```typescript
import * as data from './data.json';
```

It is required to configure `resolveJsonModule` in `tsconfig` for this to work.
