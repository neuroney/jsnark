/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit58 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit58(String circuitName) {
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
        Wire x05 = x04.mul(inputs[0]);
        Wire x06 = x05.mul(inputs[0]);
        Wire x07 = x06.mul(inputs[0]);
        Wire x08 = x07.mul(inputs[0]);

Wire x11 = inputs[1];
Wire x12 = x11.mul(inputs[1]);
Wire x13 = x12.mul(inputs[1]);
Wire x14 = x13.mul(inputs[1]);
Wire x15 = x14.mul(inputs[1]);
Wire x16 = x15.mul(inputs[1]);
Wire x17 = x16.mul(inputs[1]);
Wire x18 = x17.mul(inputs[1]);



Wire x21 = inputs[2];
Wire x22 = x21.mul(inputs[2]);
Wire x23 = x22.mul(inputs[2]);
Wire x24 = x23.mul(inputs[2]);
Wire x25 = x24.mul(inputs[2]);
Wire x26 = x25.mul(inputs[2]);
Wire x27 = x26.mul(inputs[2]);
Wire x28 = x27.mul(inputs[2]);


Wire x31 = inputs[3];
Wire x32 = x31.mul(inputs[3]);
Wire x33 = x32.mul(inputs[3]);
Wire x34 = x33.mul(inputs[3]);
Wire x35 = x34.mul(inputs[3]);
Wire x36 = x35.mul(inputs[3]);
Wire x37 = x36.mul(inputs[3]);
Wire x38 = x37.mul(inputs[3]);

Wire x41 = inputs[4];
Wire x42 = x41.mul(inputs[4]);
Wire x43 = x42.mul(inputs[4]);
Wire x44 = x43.mul(inputs[4]);
Wire x45 = x44.mul(inputs[4]);
Wire x46 = x45.mul(inputs[4]);
Wire x47 = x46.mul(inputs[4]);
Wire x48 = x47.mul(inputs[4]);

        Wire d1 = x21;
		Wire d2 = x22;
        Wire d3 = x01.mul(x21).mul(x31);
        Wire d4 = x01.mul(x11).mul(x21).mul(x31);
        Wire d5 = x01.mul(x23).mul(x31);
        Wire d6 = x01.mul(x24).mul(x31);
        Wire d7 = x03.mul(x23).mul(x31);
        Wire d8 = x02.mul(x26);

        Wire result = d1.add(d2).add(d3).add(d4).add(d5).add(d6).add(d7).add(d8);


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
        Circuit58 generator = new Circuit58("Circuit58");
        generator.generateCircuit();
        generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
        generator.prepFiles();
		//generator.runLibsnark();
	}

}
