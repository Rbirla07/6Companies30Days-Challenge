import java.util.*;

public class EPS {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        Map<String, List<Integer>> employeeAccessTimes = new HashMap<>();
        for (List<String> accessTime : accessTimes) {
            String employeeName = accessTime.get(0);
            int time = Integer.parseInt(accessTime.get(1));
            employeeAccessTimes.computeIfAbsent(employeeName, k -> new ArrayList<>()).add(time);
        }

        List<String> highAccessEmployees = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : employeeAccessTimes.entrySet()) {
            String employeeName = entry.getKey();
            List<Integer> times = entry.getValue();
            if (isHighAccess(times) ) {
                highAccessEmployees.add(employeeName);
            }
        }

        return highAccessEmployees;
    }

    private static boolean isHighAccess(List<Integer> times) {
        if (times.size() < 3) {
            return false;
        }

        Collections.sort(times);

        for(int i = 0; i< times.size()-2; i++){
            int time = times.get(i);
            int time1 = times.get(i+1);
            int time2 = times.get(i+2);

            if(time1 - time < 100 && time2 - time< 100){
                return true;
            }

        }

        return false;
    }
}
