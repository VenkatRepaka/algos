package strings.coursera.week4;

public class SuffixArrayLong {

    public int[] countingSortChar(String text) {
        int[] charArray = new int[200];
        int[] order = new int[text.length()];
        for(int i=0;i<text.length();i++) {
            charArray[text.charAt(i)] += 1;
        }
        for(int i=1;i<charArray.length;i++) {
            charArray[i] += charArray[i-1];
        }
        for(int i=order.length-1;i>=0;i--) {
            order[--charArray[text.charAt(i)]] = i;
        }
        return order;
    }

    public int[] computeClass(String text, int[] order) {
        int[] classes = new int[text.length()];
        int class_ = 0;
        classes[order[0]] = class_;
        for (int i = 1; i < order.length; i++) {
            if(text.charAt(order[i]) == text.charAt(order[i-1])) {
                classes[order[i]] = class_;
            }
            else {
                classes[order[i]] = ++class_;
            }
        }
        return classes;
    }

    public int[] sortDoubled(String text, int L, int[] order, int[] sortedClass) {
        int[] newOrder = new int[text.length()];
        int[] count = new int[sortedClass.length];
        int start, class_;
        for(int i=0;i<text.length();i++) {
            count[sortedClass[i]] += 1;
        }
        for(int i=1;i<count.length;i++) {
            count[i] += count[i-1];
        }
        for (int i = text.length()-1; i >= 0; i--) {
            start = (order[i] - L + text.length()) % text.length();
            // System.out.print(start + " ");
            class_ = sortedClass[start];
            count[class_] -= 1;
            newOrder[count[class_]] = start;
        }
        // System.out.println();
        return newOrder;
    }

    public int[] updateClasses(int[] newOrder, int[] computedClasses, int l) {
        int n = newOrder.length;
        int[] newClasses = new int[n];
        int curr, prev, mid, midPrev;
        for(int i=1;i<n;i++) {
            curr = newOrder[i];
            prev = newOrder[i-1];
            mid = (curr + l)%n;
            midPrev = (prev + l)%n;
            if(computedClasses[curr] != computedClasses[prev] || computedClasses[mid] != computedClasses[midPrev]) {
                newClasses[curr]= newClasses[prev] + 1;
            }
            else {
                newClasses[curr]= newClasses[prev];
            }
        }
        return newClasses;
    }

    public int[] buildSuffixArray(String text) {
        int[] order = countingSortChar(text);
        int[] computedClasses = computeClass(text, order);
        int l = 1;
        while(l < text.length()) {
            order = sortDoubled(text, l, order, computedClasses);
            computedClasses = updateClasses(order, computedClasses, l);
            l *= 2;
        }
        return order;
    }

    public static void main(String[] args) {
        SuffixArrayLong suffixArrayMatching = new SuffixArrayLong();
        /*String text = "ababaa$";
        int[] order = suffixArrayMatching.countingSortChar(text);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
        System.out.println();
        int[] computedClasses = suffixArrayMatching.computeClass(text, order);
        for (int i = 0; i < order.length; i++) {
            System.out.print(computedClasses[i] + " ");
        }
        System.out.println();
        int[] newOrder = suffixArrayMatching.sortDoubled(text, 2, order, computedClasses);
        for (int i = 0; i < newOrder.length; i++) {
            System.out.print(newOrder[i] + " ");
        }*/
        int[] order = suffixArrayMatching.buildSuffixArray("AACGATAGCGGTAGA$");
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
    }


}
