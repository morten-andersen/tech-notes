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

#### Slack - Disable Notifications

[Slack app on Linux: How to disable the "blue circle" icon on channel activity?](https://superuser.com/questions/1211975/slack-app-on-linux-how-to-disable-the-blue-circle-icon-on-channel-activity)

```bash
cd /usr/lib/slack/resources/app.asar.unpacked/dist/resources
sudo cp slack-taskbar-unread.ico{,.ori}
sudo cp slack-taskbar-{rest,unread}.ico
```
