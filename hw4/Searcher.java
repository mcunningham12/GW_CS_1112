public class Searcher {
    static int[] data = {2,3,5,8,13,21,34,55,89,144};

    public static void main( String[] argv) {
        boolean found;
        int value=40;
        found = search(data, value,0,data.length-1);
        System.out.println("found=" + found);
    }

    static boolean search(int[] A, int value, int start, int end) {
        System.out.println("start=" + start);
        System.out.println("end=" + end);
        if (start>end) {
            return false;
        }
        int mid = (start+end)/2;
        
        if (A[mid] == value) {
            return true;
        } else if (value <= A[mid]) {
            return search(A,value, start, mid-1);
        } else {
            return search(A,value,mid+1,end);
        }
    }
}
