/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit515 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit515(String circuitName) {
		super(circuitName);
	}

	@Override
	protected void buildCircuit() {

		// declare input array of length 5.
		inputs = createInputWireArray(5);

        Wire x01 = inputs[0];
        Wire x02 = x01.mul(inputs[0]);

        Wire x11 = inputs[1];
        Wire x12 = x11.mul(inputs[1]);
        Wire x13 = x12.mul(inputs[1]);
        Wire x14 = x13.mul(inputs[1]);
        Wire x15 = x14.mul(inputs[1]);
        Wire x16 = x15.mul(inputs[1]);

        Wire x21 = inputs[2];
        Wire x22 = x21.mul(inputs[2]);
        Wire x23 = x22.mul(inputs[2]);

        Wire x31 = inputs[3];

        Wire x41 = inputs[4];
        Wire x42 = x41.mul(inputs[4]);
        Wire x43 = x42.mul(inputs[4]);
        Wire x44 = x43.mul(inputs[4]);
        Wire x45 = x44.mul(inputs[4]);


        Wire d1 = x11;
		Wire d2 = x12;
        Wire d3 = x12.mul(x41);
        Wire d4 = x12.mul(x42);
        Wire d5 = x15;
        Wire d6 = x14.mul(x42);
        Wire d7 = x16.mul(x41);
        Wire d8 = x01.mul(x15).mul(x21).mul(x41);
        Wire d9 = x14.mul(x22).mul(x43);
        Wire d10 = x02.mul(x13).mul(x22).mul(x43);
        Wire d11 = x01.mul(x16).mul(x22).mul(x42);
        Wire d12 = x16.mul(x21).mul(x45);
        Wire d13 = x01.mul(x15).mul(x23).mul(x44);
        Wire d14 = x02.mul(x16).mul(x23).mul(x43);
        Wire d15 = x02.mul(x16).mul(x22).mul(x31).mul(x44);

        Wire result = d1.add(d2).add(d3).add(d4).add(d5).add(d6).add(d7).add(d8).add(d9).add(d10).add(d11).add(d12).add(d13).add(d14).add(d15);


		// mark the wire as output
		makeOutput(result);

	}

	@Override
	public void generateSampleInput(CircuitEvaluator circuitEvaluator) {
		circuitEvaluator.setWireValue(inputs[0], 614649130);
		circuitEvaluator.setWireValue(inputs[1], 34361204);
		circuitEvaluator.setWireValue(inputs[2], 816626697);
		circuitEvaluator.setWireValue(inputs[3], 255488704);
		circuitEvaluator.setWireValue(inputs[4], 1208550547);
	}

	public static void main(String[] args) throws Exception {
        long stime = System.currentTimeMillis();
		Circuit515 generator = new Circuit515("Circuit515");
		generator.generateCircuit();
		generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
		generator.prepFiles();
		//generator.runLibsnark();
	}

}
