import java.util.Base64;
import java.util.Arrays;
import java.nio.file.*;
import java.io.*;
import static java.nio.charset.StandardCharsets.UTF_8;

class Base64Test {

  private static final String TEST = "The quick brown fox jumps over the lazy dog - øæå";

  /**
   * encode and decode using strings
   */
  private static String encodeString(String in) {
    Base64.Encoder encoder = Base64.getEncoder();
    return encoder.encodeToString(in.getBytes(UTF_8));
  }

  private static String decodeString(String in) {
    Base64.Decoder decoder = Base64.getDecoder();
    return new String(decoder.decode(in), UTF_8);
  }

  /**
   * encode and decode wrapping IO streams
   */
  private static Path encodeFile(Path src) throws IOException {
    Path dest = src.resolveSibling(src.getFileName().toString() + ".enc");
    Base64.Encoder encoder = Base64.getMimeEncoder();
    try (OutputStream out = Files.newOutputStream(dest)) {
      Files.copy(src, encoder.wrap(out));
    }
    return dest;
  }

  private static Path decodeFile(Path src) throws IOException {
    Path dest = src.resolveSibling(src.getFileName().toString().replace(".enc", ".dec"));
    Base64.Decoder decoder = Base64.getMimeDecoder();
    try (InputStream in = Files.newInputStream(src)) {
      Files.copy(decoder.wrap(in), dest);
    }
    return dest;
  }


  public static void main(String[] args) throws Exception {
    String encoded = Base64Test.encodeString(TEST);
    System.out.println("Encoded: " + encoded);
    String decoded = Base64Test.decodeString(encoded);
    System.out.println("String roundtrip ok? " + TEST.equals(decoded));

    Path sourceFile = FileSystems.getDefault().getPath("Base64Test.java");
    Path encodedFile = Base64Test.encodeFile(sourceFile);
    try {
      Path decodedFile = Base64Test.decodeFile(encodedFile);
      try {
        System.out.println("File roundtrip ok? " + Arrays.equals(Files.readAllBytes(sourceFile), Files.readAllBytes(decodedFile)));
      } finally {
        Files.deleteIfExists(decodedFile);
      }
    } finally {
      Files.deleteIfExists(encodedFile);
    }
  }
}
