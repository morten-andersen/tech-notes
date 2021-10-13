### Ubuntu - Tips and Tricks

#### Remove the "System Program Problem Detected" popup

The crash reports are in `/var/crash` - these can safely be removed

Disable Ubuntu [Apport](https://wiki.ubuntu.com/Apport) for crash reports completely can be done by setting `enabled=0` in `/etc/default/apport`

#### Change the System Locale

```bash
# show current settings
localectl

# list locales
localectl list-locales

# set locale to en_DK
localectl set-locale LANG=en_DK.UTF-8
```
