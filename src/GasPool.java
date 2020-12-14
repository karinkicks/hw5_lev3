
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float max_fuel_reserve = 200f;
    private float real_fuel_reserve=20f;

    public float request(float amount){
        try{
            lock.writeLock().lock();
            if(amount>real_fuel_reserve){
                return 0;
            }
            real_fuel_reserve-=amount;
            return amount;
        }catch (Exception e){
         e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
       return 0f;
    }


    public String info(){
        try{
            lock.writeLock().lock();
            return "GasPool{" +
                    "real_fuel_reserve=" + real_fuel_reserve +
                    '}';
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return null;
    }
}
