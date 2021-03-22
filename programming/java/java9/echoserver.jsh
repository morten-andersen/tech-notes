// example of using JShell - works from Java 9
// source: https://www.javaspecialists.eu/archive/Issue250.html
// after being started it will echo all characters back.
// test by telnet 8080

try (ServerSocket ss = new ServerSocket(8080);
    Socket s = ss.accept();
    InputStream in = s.getInputStream();
    OutputStream out = s.getOutputStream()) {
  in.transferTo(out);
}
