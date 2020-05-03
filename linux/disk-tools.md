### Disk Tools

#### Safe Remove - [`srm`](https://manpages.ubuntu.com/manpages/focal/en/man1/srm.1.html)

The secure remove toolkit:

* `srm`
* `sfill`
* `sdmem`

#### Fill a Harddisk with 1000 1 GB files

```bash
for i in {000..999}; do dd if=/dev/zero of=filename${i} bs=$((1024*1024)) count=1024; done
```

The two leading zeroes in the range `00` means that all generated integers will be left padded to be 3 digits long.
