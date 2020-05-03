### Linux Services

https://linoxide.com/linux-how-to/enable-disable-services-ubuntu-systemd-upstart/

#### modern: `systemd` - `systemctl`

```
sudo systemctl status <service>
sudo systemctl stop <service>
sudo systemctl start <service>
sudo systemctl disable <service>
sudo systemctl enable <service>
sudo systemctl list-unit-files | grep enabled
sudo systemctl | grep running
sudo systemctl list-units --type=service --state=running
sudo systemctl list-units --type=service --state=active
```

#### before that: `upstart`

#### old: `sysV (rc.d)``
