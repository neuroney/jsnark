/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit52 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit52(String circuitName) {
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



Wire x21 = inputs[2];
Wire x22 = x21.mul(inputs[2]);


Wire x31 = inputs[3];
Wire x32 = x31.mul(inputs[3]);

Wire x41 = inputs[4];
Wire x42 = x41.mul(inputs[4]);

        Wire d1 = x21;
		Wire d2 = x22;

        Wire result = d1.add(d2);


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
        Circuit52 generator = new Circuit52("Circuit52");
        generator.generateCircuit();
        generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
        generator.prepFiles();
		//generator.runLibsnark();
	}

}
