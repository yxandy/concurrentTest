/*
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class test {

    public static void main(String[] args) throws Exception {
    	 ExecutorService exec = Executors.newCachedThreadPool();  
         List<test2> test2s = new ArrayList<test2>(); 
         for (int i = 0; i < 10; i++) {
			test2s.add(new test2());
		}
         List<Future<Double>> futures = exec.invokeAll(test2s,  
                 2000, TimeUnit.MILLISECONDS);//invokeAll 第一个参数是任务列表；第二个参数是过期时间；第三个是过期时间单位 
         for (Future<Double> future : futures) {
			Double d = future.get();
			System.out.println(d);
		}
         exec.shutdown();
         System.out.println("yeah!");
    }

}
