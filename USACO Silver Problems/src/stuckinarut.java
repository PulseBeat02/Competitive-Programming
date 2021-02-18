import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class stuckinarut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];
        for (int i = 0; i < cows.length; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y, dir);
        }
        List<Stop> stops = new ArrayList<>();
        criticalPoints(cows, stops);
        Collections.sort(stops);
		for (Stop stop : stops) {
			if (cows[stop.blame].stoppedTime > stop.blameTime) {
				cows[stop.whoStopped].stoppedTime = Math.min(cows[stop.whoStopped].stoppedTime, stop.whoStoppedTime);
			}
		}
        for (int i = 0; i < cows.length; i++) {
            System.out.println(recurse(cows, i));
        }
    }

    private static int recurse(Cow[] cow, int index) {
        int sum = 0;
        for (Stop s : cow[index].stopping) {
            if ((s.blameTime < cow[index].stoppedTime) && (s.whoStoppedTime == cow[s.whoStopped].stoppedTime)) {
                sum++;
                sum += recurse(cow, s.whoStopped);
            }
        }
        return sum;
    }

    private static void criticalPoints(Cow[] cows, List<Stop> stops) {
        for (int i = 0; i < cows.length; i++) {
            for (int j = 0; j < cows.length; j++) {
                if (cows[i].direction == 'E' && cows[j].direction == 'N') {
                /*
                Case #1

                ___
                 |

                * --->
             (a1, b1)
                       ^
                       |
                       |
                       * (a2, b2)

                First Point -> (a1, b1)
                Second Point -> (a2, b2)
                Intersection Point -> (a2, b1)
                Distance/Time -> b1 - b2

                First Point must go EAST
                Second Point must go NORTH

                a1 < a2
                b1 > b2

                (a2 - a1) < (b1 - b2)

                 */
                    if (cows[j].y < cows[i].y && cows[j].x > cows[i].x
                            && cows[j].x - cows[i].x < cows[i].y - cows[j].y) {
                    	// i stop j
                        Stop stop = new Stop(cows[j].x - cows[i].x, cows[i].y - cows[j].y, j, i);
                        cows[i].stopping.add(stop);
                        stops.add(stop);
                    }

                /*
                Case #2

                ---|

                * ------>
                (a1, b1)   ^
                           |
                           |
                           |
                        (a2, b2)

                First Point -> (a1, b1)
                Second Point -> (a2, b2)
                Intersection Point -> (a2, b1)
                Distance/Time -> a2 - a1

                First Point must go EAST
                Second Point must go NORTH

                b1 > b2
                a1 < a2

                (a2 - a1) > (b1 - b2)

                 */
                    else if (cows[i].y > cows[j].y && cows[i].x < cows[j].x
                            && cows[j].x - cows[i].x > cows[i].y - cows[j].y) {
                    	// j stop i
                        Stop stop = new Stop(cows[i].y - cows[j].y, cows[j].x - cows[i].x, i, j);
                        cows[j].stopping.add(stop);
                        stops.add(stop);
                    }

                }
            }
        }
    }

    /*
        Helper Class for Stops
    */
    public static class Stop implements Comparable<Stop> {
        final int blameTime;
        final int whoStoppedTime;
        final int whoStopped;
        final int blame;
        public Stop(int blameTime, int whoStoppedTime, int whoStopped, int blame) {
            this.blameTime = blameTime;
            this.whoStoppedTime = whoStoppedTime;
            this.whoStopped = whoStopped;
            this.blame = blame;
        }
		@Override
		public int compareTo(Stop other) {
			return this.whoStoppedTime - other.whoStoppedTime;
		}
    }

    /*
        Helper Class for Cows
    */
    private static class Cow {
        final int x;
        final int y;
        final char direction;
        final List<Stop> stopping;
        int stoppedTime;
        public Cow(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.direction = dir;
            this.stoppedTime = Integer.MAX_VALUE;
            this.stopping = new ArrayList<>();
        }
    }

}
