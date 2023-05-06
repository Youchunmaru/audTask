import java.util.ArrayList;

public class Primes {

    private long number = 2;
    private long index = 1;
    private ArrayList<Long> primes = new ArrayList<>();
    private boolean showUpdate = true;
    private long start;
    private int time = 0;
    private double calcTime;
    private ArrayList<Double> timeDiffList = new ArrayList<>();

    public Primes(int index){
        this.index = index;
        primes.add(number);
        calcTime = Math.pow(index, 1.5)/100000;
    }

    public void start(){
        start = System.currentTimeMillis();
        System.out.println("Calculating the " + index + "th prime number:");
        System.out.println("est. time: " + calcTime/1000 + "s");
        long testNumber = 3;
        while (primes.size() < index) {
            if (isPrime(testNumber)) {
                primes.add(testNumber);
            }
            if (showUpdate) {
                update();
            }
            testNumber +=2;
        }
        number = primes.get(primes.size()-1);
        if (showUpdate) {
            System.out.println(toString());
            System.out.println("execution time: " + time + "ms");
            int count = 0;
            double sum = 0;
            timeDiffList.remove(0);
            for (Double num : timeDiffList) {
                sum += num;
                count++;
            }
            System.out.println("diff: " + sum/count);
        }
    }

    private boolean isPrime(long number){
        for (int i = 0 ; primes.get(i)<=number/primes.get(i);i++) {
            if (number % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public long nthPrime(int n){
        boolean[] primes = new boolean[Integer.MAX_VALUE/8];
        int count = 1;
        for (int i = 2; i < primes.length && count <= n;i++) {
            if (!primes[i]) {
                count++;
                if (count == n) {
                    return i;
                }
                System.out.println(count + "th prime: " + i);
                for (int j = i*i; j < primes.length; j += i) {
                    //System.out.println(count + "th prime: " + i + " -> multiple: " + j);
                    if (j < 0){
                        break;
                    }

                    primes[j] = true;
                }
            }
        }
        return -1;
    }

    private void update(){
        long delta;
        int update = 10000;
        if ((delta = System.currentTimeMillis() - start) >= update) {
            double timeDiffFactor = calcTime/(time*1/((float)primes.size()/index));
            timeDiffList.add(timeDiffFactor);
            double estTime = (calcTime-time*1/((float)primes.size()/index))/1000;
            System.out.printf("%5.2f%s%n",(float)primes.size()/index*100,"%");
            System.out.printf("%s%.2f%s%n","est. time to complition: ", estTime*timeDiffFactor,"s");
            time += delta;
            start = System.currentTimeMillis();
        }
    }

    public void setShowUpdate(boolean update){
        showUpdate = update;
    }

    @Override
    public String toString(){
        return "The " + index + "th prime number is " + number + " and needed " + (System.currentTimeMillis()-start)/1000 + "s to calculate!";
    }
}
class PrimeRun{
    public static void main(String[] args) {
        Primes primeNumber = new Primes(1000000);
        primeNumber.setShowUpdate(false);
        primeNumber.start();
        System.out.println(primeNumber.toString());
        //System.out.println(primeNumber.nthPrime(1000000));
    }
}