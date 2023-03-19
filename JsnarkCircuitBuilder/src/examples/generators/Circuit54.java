/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit54 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit54(String circuitName) {
		super(circuitName);
	}

	@Override
	protected void buildCircuit() {

		// declare input array of length 5.
		inputs = createInputWireArray(5);

        Wire x01 = inputs[0];
        Wire x02 = x01.mul(inputs[0]);
        Wire x03 = x02.mul(inputs[0]);
        Wire x04 = x03.mul(inputs[0]);

Wire x11 = inputs[1];
Wire x12 = x11.mul(inputs[1]);
Wire x13 = x12.mul(inputs[1]);
Wire x14 = x13.mul(inputs[1]);



Wire x21 = inputs[2];
Wire x22 = x21.mul(inputs[2]);
Wire x23 = x22.mul(inputs[2]);
Wire x24 = x23.mul(inputs[2]);


Wire x31 = inputs[3];
Wire x32 = x31.mul(inputs[3]);
Wire x33 = x32.mul(inputs[3]);
Wire x34 = x33.mul(inputs[3]);

Wire x41 = inputs[4];
Wire x42 = x41.mul(inputs[4]);
Wire x43 = x42.mul(inputs[4]);
Wire x44 = x43.mul(inputs[4]);

        Wire d1 = x21;
		Wire d2 = x22;
        Wire d3 = x01.mul(x21).mul(x31);
        Wire d4 = x01.mul(x11).mul(x21).mul(x31);

        Wire result = d1.add(d2).add(d3).add(d4);


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
        Circuit54 generator = new Circuit54("Circuit54");
        generator.generateCircuit();
        generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
        generator.prepFiles();
		//generator.runLibsnark();
	}

}
