import java.util.*; 
public class Batch extends Timetable{
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    boolean add(Course x, Professor y) {
        int i, j, k, m, n;

        // Clear the list
        list.clear();

        // Iterate through the timetable to find available slots (excluding the fourth slot)
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                // Skip the fourth slot (j == 3) in each day
                if (j != 3 && y.a[i][j] == null && this.a[i][j] == null) {
                    // Skip the third slot (j == 2) for labs
                    if (!(x.getName().toLowerCase().contains("lab") && j == 2)) {
                        list.add(i * 10 + j);
                    }
                }
            }
        }

        // Check if the course has two credits
        boolean isTwoCredits = x.getCredits() == 2;

        // Allocate consecutive slots for two-credit subjects randomly on the same day
        if (isTwoCredits && list.size() >= 2) {
            // If the course has two credits and there are enough available slots, allocate consecutive slots on the same day randomly
            k = rand.nextInt(list.size() - 1);
            m = list.get(k) / 10; // Extract day from the first slot

            for (i = 0; i < 2; i++) {
                n = list.get(k + i) % 10;
                this.a[m][n] = x.getName() + "(" + y.getName() + ")";
                y.a[m][n] = this.getName() + "(" + x.getName() + ")";
            }
        } else if (!isTwoCredits && list.size() >= x.getCredits()) {
            // If the course doesn't have two credits and there are enough slots, allocate randomly
            for (i = 0; i < x.getCredits(); i++) {
                k = rand.nextInt(list.size());
                n = list.get(k) % 10;
                m = list.get(k) / 10;
                this.a[m][n] = x.getName() + "(" + y.getName() + ")";
                y.a[m][n] = this.getName() + "(" + x.getName() + ")";
                list.remove(k);
            }
        }

        // Clear the list for future use
        list.clear();
        return true;
    }

}