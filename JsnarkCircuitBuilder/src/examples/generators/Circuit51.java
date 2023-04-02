/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;
import java.io.*;
import circuit.config.Config;

public class Circuit51 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit51(String circuitName) {
		super(circuitName);
	}

	@Override
	protected void buildCircuit() {
		// declare input array of length 5.

		FileReader file = null;
		int [][]cc = new int[1125][5];
		try {
			file = new FileReader("GTDpoly.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(file);//读取文件
        try {
            String []sp = null;
            int count=0;
			String line = ""; 
            while((line=br.readLine())!=null) {//按行读取
                sp = line.split(" ");//按空格进行分割
                for(int i=0;i<sp.length;i++){
					cc[count][i] = Integer.parseInt(sp[i]);
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

		inputs = createInputWireArray(5);

		Wire result = inputs[0];
		boolean inited;
		int degree_f = 4;
		for (int i = 1; i < 1125; ++i) {
			if (cc[i][0]+cc[i][1]+cc[i][2]+cc[i][3]+cc[i][4] > degree_f) {
				break;
			}
			inited = false;
			Wire Monomial = inputs[0];
			for (int j = 0; j < 5; ++j) {
				if (!inited && cc[i][j] != 0) {
					inited = true;
					Monomial.add(inputs[j]).sub(inputs[0]);
					for (int k = 1; k < cc[i][j]; ++k) {
						Monomial = Monomial.mul(inputs[j]);
					}
					continue;
				}
				for (int k = 0; k < cc[i][j]; ++k) {
					Monomial = Monomial.mul(inputs[j]);
				}
			}
			result.add(Monomial);
		}
		result.sub(inputs[0]);

		// mark the wire as output
		makeOutput(result);

	}

	@Override
	public void generateSampleInput(CircuitEvaluator circuitEvaluator) {
		circuitEvaluator.setWireValue(inputs[0], 614649130);
		circuitEvaluator.setWireValue(inputs[1], 343691204);
		circuitEvaluator.setWireValue(inputs[2], 816626697);
		circuitEvaluator.setWireValue(inputs[3], 255488704);
		circuitEvaluator.setWireValue(inputs[4], 1208550547);
	}

	public static void main(String[] args) throws Exception {

        long stime = System.currentTimeMillis();
        Circuit51 generator = new Circuit51("Circuit54");
        generator.generateCircuit();
        generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
        generator.prepFiles();
		//generator.runLibsnark();
	}

}
