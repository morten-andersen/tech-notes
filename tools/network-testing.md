### Network Testing

Online tools for testing **network settings** for HTTP and mail servers

#### Network Layer

* [Qualys SSL Labs](https://www.ssllabs.com/) for testing SSL/TLS settings
* [DNS Checker](https://dnschecker.org/) for testing DNS settings from various locations, i.e. DNS propagation
* [Rebex SSH Check](https://sshcheck.com/) for testing SSH server settings
* [IPv6 Tester](https://ip6.nl/) for testing IPv6 settings. Both for your local network as well as for servers

#### HTTP Settings

* [Mozilla Observatory](https://observatory.mozilla.org/) scans HTTP settings and includes third-party tests
* [Security Headers](https://securityheaders.com/) for testing HTTP security headers such as [CSP](https://developer.mozilla.org/en-US/docs/Web/HTTP/CSP), HSTS, etc.
* [CSP Evaluator](https://csp-evaluator.withgoogle.com/) for testing a sites CSP policy

#### Mail Settings

* [Mail-tester](https://www.mail-tester.com/) for testing mail settings such as [SPF, DKIM, DMARC](https://protonmail.com/support/knowledge-base/anti-spoofing/)
  * **Sender Policy Framework (SPF)** - tells the world what hosts or ip’s are allowed to send email for your domain
  * **Domain Keys Identified Mail (DKIM)** - method of email authentication that cryptographically verifies if an email is sent by trusted servers and untampered. Basically, when a server sends an email for your domain, it will calculate an encrypted hash of the email contents using a private key (that only trusted servers know) and add it to the email headers as a DKIM signature. The receiving server will verify the email contents by looking up the corresponding public key in your domain’s DNS records, decrypting the encrypted hash, and calculating a new hash based on the email contents it received to see if the decrypted hash matches the new hash.
  * **Domain-based Message Authentication, Reporting and Conformance (DMARC)** - tells receiving email servers what to do if they receive mails that fail SPF or DKIM. Basically, there are three actions for receiving servers to take if BOTH SPF and DKIM checks fail: `none`, `quarantine`, and `reject`.
* [Sikker på nettet](https://sikkerpånettet.dk) (same testing engine as [Internet.nl](https://en.internet.nl/)) - testing of email settings as well as DNSSEC, etc.

#### DNS Settings

* [Verisign Labs - DNS Tools](https://www.verisign.com/en_US/company-information/verisign-labs/internet-security-tools/index.xhtml) a collection a DNS tools
  * [DNSSEC Debugger](https://dnssec-debugger.verisignlabs.com/)
  * [DNS Visualizer](https://dnsviz.net/) - visualizing DNS security
* [The Root Canary Project - DNS Resolver algorithm test](https://rootcanary.org/test.html)
* [Internet Society - DNSSEC Tools](https://www.internetsociety.org/deploy360/dnssec/tools/) list of tools for testing DNSSEC
  * **DANE - DNS-based Authentication of Named Entities** - DNS records which tell other mail servers that a mail server supports TLS encryption and what certificate to expect when connecting to the sending server (only secure if DNSSEC it enabled) ([Internet Society - DANE](https://www.internetsociety.org/resources/deploy360/dane/))
  * **DANE vs. MTA-STS** [ProtonMail Security Update -> DANE and MTA-STS – thwarting active attackers](https://protonmail.com/blog/security-updates-2019/). MTA-STS is HSTS for email. The sending mail server looks up and caches an MTA-STS policy, which tells it that the receiving mail server supports encryption (not effective for domains with limited mail traffic)
* [DK Hostmaster -> DNSSEC](https://www.dk-hostmaster.dk/da/dnssec)
