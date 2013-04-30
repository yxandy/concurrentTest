import java.util.concurrent.Callable;


public class test2 implements Callable<Double>{

	@Override
	public Double call() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(Thread.class.getName());
		return Math.random();
	}

}
