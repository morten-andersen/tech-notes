### Ubuntu APT Package Manager

Advanced Package Tool.

https://linuxize.com/post/how-to-install-and-use-docker-on-ubuntu-18-04/

#### Search for a Package

```bash
apt search <package>
```

#### List Package Versions

```bash
apt list -a <package>
```

Eg. for `docker-ce` this could list something like:

```bash
apt list -a docker-ce

# output
docker-ce/bionic 5:18.09.7~3-0~ubuntu-bionic amd64
docker-ce/bionic 5:18.09.6~3-0~ubuntu-bionic amd64
docker-ce/bionic 5:18.09.5~3-0~ubuntu-bionic amd64
```

#### Install Specific Package Version

```bash
apt install <package>=<version>
```

Eg. for `docker-ce`:

```bash
apt install docker-ce=5:18.09.6~3-0~ubuntu-bionic
```
