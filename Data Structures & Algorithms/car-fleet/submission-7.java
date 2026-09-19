class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Compute time it takes for each car to reach the target
        double[][] cars = new double[position.length][3];
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - position[i]) / speed[i];
            cars[i][0] = time; // time to reach target for car i.
            cars[i][1] = (double) position[i]; // position of car i.
            cars[i][2] = (double) speed[i]; // speed of car i.
        }

        // Sort cars in descending order of position. Cars
        // closest to the target are processed first.
        Arrays.sort(cars, (a, b) -> Double.compare(b[1], a[1]));

        // For each car:
        // 1. Push the time it takes the target onto a stack
        // 2. If the new car's time is less than or equal to
        // the time before it, it catches up and merges with
        // that fleet -> don't add it to the stack.
        Deque<Double> fleets = new ArrayDeque<>();
        for (int i = 0; i < cars.length; i++) {
            if (fleets.size() >= 1 && cars[i][0] > fleets.peek()) {
                fleets.push(cars[i][0]);
            } else if (fleets.isEmpty()) {
                fleets.push(cars[i][0]);
            }
        }

        // DEBUGGING ONLY
        // for (int i = 0; i < cars.length; i++) {
        //     System.out.println(cars[i][1]);
        // }
        return fleets.size();
    }
}
