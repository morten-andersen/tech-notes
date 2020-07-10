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
