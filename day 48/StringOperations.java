package stringoperations;

public class StringOperations {

    public int findLength(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            count++;
        }

        return count;
    }

    public String reverseString(String str) {

        int len = findLength(str);
        char[] arr = str.toCharArray();
        char[] rev = new char[len];

        int j = 0;

        for (int i = len - 1; i >= 0; i--) {
            rev[j] = arr[i];
            j++;
        }

        return new String(rev);
    }

    public String toUpper(String str) {

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] - 32);
            }

        }

        return new String(arr);
    }
}