## Network Tools

### Open connection to a port ###

cat with /dev/tcp or /dev/udp

```
cat < /dev/tcp/<hostname>/<port>
```

### Show the route of a specific IP address

```
ip route get <IP-address>
```

### Dig - network lookup

lookup nameservers (type = NS) for a domain
```
dig <domain> NS
```

lookup information at a specific nameserver

```
dig @<nameserver> <server>
```

### Echoping - pinging tcp / udp / http

```
echoping -h / -v penni.io:80
```

### list listening network services

```
sudo netstat -ltnp
```
