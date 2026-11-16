/*
If, 1 boat can carry 6 kg max and 1/2 people max
sort the array -
1 2 2 3 3 limit - 3 and max_count - 2
After sorting:
Put the heaviest person in a boat.
Try to pair them with the lightest person.
If they fit, take both.
Otherwise, the heavy person goes alone.
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }
}