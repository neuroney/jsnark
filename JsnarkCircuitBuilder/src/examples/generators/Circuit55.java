/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit55 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit55(String circuitName) {
		super(circuitName);
	}

	@Override
	protected void buildCircuit() {

		// declare input array of length 5.
		inputs = createInputWireArray(5);

        Wire x01 = inputs[0];

        Wire x11 = inputs[1];

        Wire x21 = inputs[2];
        Wire x22 = x21.mul(inputs[2]);
        Wire x23 = x22.mul(inputs[2]);


        Wire d1 = x21;
		Wire d2 = x22;
        Wire d3 = x01.mul(x11).mul(x21);
        Wire d4 = x01.mul(x23);
        Wire d5 = x01.mul(x11).mul(x23);

        Wire result = d1.add(d2).add(d3).add(d4).add(d5);

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
		Circuit55 generator = new Circuit55("Circuit55");
		generator.generateCircuit();
		generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
		generator.prepFiles();
		//generator.runLibsnark();
	}

}
