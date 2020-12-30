### Network Tools

#### Open connection to a port ###

cat with /dev/tcp or /dev/udp

```
cat < /dev/tcp/<hostname>/<port>
```

#### Connection to TLS service

```
openssl s_client -host <servername> -port <port>
```

* https = port 443
* smtps = port 993

#### Show the route of a specific IP address

```
ip route get <IP-address>
```

#### Dig - network lookup

lookup nameservers (type = NS) for a domain
```
dig <domain> NS
```

##### DNS Types:

* `NS` - nameservers
* `A` / `AAAA` - address record (IPv4 / IPv6)
* `SOA` - authoritative zone information
* `MX` - mail
* `TXT` - text record
* `CNAME` - alias to other DNS name

lookup information at a specific nameserver

```
dig @<nameserver> <server>
```

list all dns entries (restricted if zone transfer is not enabled)

```
dig +nocmd <domain> any +multiline +noall +answer
```

#### Echoping - pinging tcp / udp / http

```
echoping -h / -v penni.io:80
```

#### list listening network services

```
sudo netstat -ltnp
```
