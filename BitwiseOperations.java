public class BitwiseOperations {
    public static void main(String[] args) {
        // Define the string
        String text = "Hello World";
        // Display the original string
        System.out.println("Original String: " + text);
        // Perform AND operation with 127 and display the result
        System.out.print("AND with 127: ");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char andResult = (char) (c & 127);
            System.out.print(andResult);
        }
        System.out.println();
        // Perform XOR operation with 127 and display the result
        System.out.print("XOR with 127: ");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char xorResult = (char) (c ^ 127);
            System.out.print(xorResult);
        }
        System.out.println();
    }
}
