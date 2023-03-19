/*******************************************************************************
 * Author: Ahmed Kosba <akosba@cs.umd.edu>
 *******************************************************************************/
package examples.generators;

import circuit.eval.CircuitEvaluator;
import circuit.structure.CircuitGenerator;
import circuit.structure.Wire;

public class Circuit518 extends CircuitGenerator {

	private Wire[] inputs;

	public Circuit518(String circuitName) {
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
        Wire x09 = x08.mul(inputs[0]);
        Wire x010 = x09.mul(inputs[0]);
        Wire x011 = x010.mul(inputs[0]);
        Wire x012 = x011.mul(inputs[0]);
        Wire x013 = x012.mul(inputs[0]);
        Wire x014 = x013.mul(inputs[0]);
        Wire x015 = x014.mul(inputs[0]);
        Wire x016 = x015.mul(inputs[0]);
        Wire x017 = x016.mul(inputs[0]);
        Wire x018 = x017.mul(inputs[0]);

Wire x11 = inputs[1];
Wire x12 = x11.mul(inputs[1]);
Wire x13 = x12.mul(inputs[1]);
Wire x14 = x13.mul(inputs[1]);
Wire x15 = x14.mul(inputs[1]);
Wire x16 = x15.mul(inputs[1]);
Wire x17 = x16.mul(inputs[1]);
Wire x18 = x17.mul(inputs[1]);
Wire x19 = x18.mul(inputs[1]);
Wire x110 = x19.mul(inputs[1]);
Wire x111 = x110.mul(inputs[1]);
Wire x112 = x111.mul(inputs[1]);
Wire x113 = x112.mul(inputs[1]);
Wire x114 = x113.mul(inputs[1]);
Wire x115 = x114.mul(inputs[1]);
Wire x116 = x115.mul(inputs[1]);
Wire x117 = x116.mul(inputs[1]);
Wire x118 = x117.mul(inputs[1]);



Wire x21 = inputs[2];
Wire x22 = x21.mul(inputs[2]);
Wire x23 = x22.mul(inputs[2]);
Wire x24 = x23.mul(inputs[2]);
Wire x25 = x24.mul(inputs[2]);
Wire x26 = x25.mul(inputs[2]);
Wire x27 = x26.mul(inputs[2]);
Wire x28 = x27.mul(inputs[2]);
Wire x29 = x28.mul(inputs[2]);
Wire x210 = x29.mul(inputs[2]);
Wire x211 = x210.mul(inputs[2]);
Wire x212 = x211.mul(inputs[2]);
Wire x213 = x212.mul(inputs[2]);
Wire x214 = x213.mul(inputs[2]);
Wire x215 = x214.mul(inputs[2]);
Wire x216 = x215.mul(inputs[2]);
Wire x217 = x216.mul(inputs[2]);
Wire x218 = x217.mul(inputs[2]);


Wire x31 = inputs[3];
Wire x32 = x31.mul(inputs[3]);
Wire x33 = x32.mul(inputs[3]);
Wire x34 = x33.mul(inputs[3]);
Wire x35 = x34.mul(inputs[3]);
Wire x36 = x35.mul(inputs[3]);
Wire x37 = x36.mul(inputs[3]);
Wire x38 = x37.mul(inputs[3]);
Wire x39 = x38.mul(inputs[3]);
Wire x310 = x39.mul(inputs[3]);
Wire x311 = x310.mul(inputs[3]);
Wire x312 = x311.mul(inputs[3]);
Wire x313 = x312.mul(inputs[3]);
Wire x314 = x313.mul(inputs[3]);
Wire x315 = x314.mul(inputs[3]);
Wire x316 = x315.mul(inputs[3]);
Wire x317 = x316.mul(inputs[3]);
Wire x318 = x317.mul(inputs[3]);

Wire x41 = inputs[4];
Wire x42 = x41.mul(inputs[4]);
Wire x43 = x42.mul(inputs[4]);
Wire x44 = x43.mul(inputs[4]);
Wire x45 = x44.mul(inputs[4]);
Wire x46 = x45.mul(inputs[4]);
Wire x47 = x46.mul(inputs[4]);
Wire x48 = x47.mul(inputs[4]);
Wire x49 = x48.mul(inputs[4]);
Wire x410 = x49.mul(inputs[4]);
Wire x411 = x410.mul(inputs[4]);
Wire x412 = x411.mul(inputs[4]);
Wire x413 = x412.mul(inputs[4]);
Wire x414 = x413.mul(inputs[4]);
Wire x415 = x414.mul(inputs[4]);
Wire x416 = x415.mul(inputs[4]);
Wire x417 = x416.mul(inputs[4]);
Wire x418 = x417.mul(inputs[4]);


        Wire d1 = x21;
		Wire d2 = x22;
        Wire d3 = x01.mul(x21).mul(x31);
        Wire d4 = x01.mul(x11).mul(x21).mul(x31);
        Wire d5 = x01.mul(x23).mul(x31);
        Wire d6 = x01.mul(x24).mul(x31);
        Wire d7 = x03.mul(x23).mul(x31);
        Wire d8 = x02.mul(x26);
        Wire d9 = x02.mul(x26).mul(x31);
        Wire d10 = x01.mul(x11).mul(x27).mul(x31);
        Wire d11 = x02.mul(x12).mul(x25).mul(x32);
        Wire d12 = x01.mul(x11).mul(x28).mul(x31).mul(x41);
        Wire d13 = x03.mul(x11).mul(x28).mul(x31);
        Wire d14 = x01.mul(x11).mul(x211).mul(x31);
        Wire d15 = x03.mul(x11).mul(x28).mul(x33);
        Wire d16 = x05.mul(x11).mul(x26).mul(x33).mul(x41);
        Wire d17 = x03.mul(x13).mul(x28).mul(x33);
        Wire d18 = x03.mul(x12).mul(x28).mul(x33).mul(x42);

        Wire result = d1.add(d2).add(d3).add(d4).add(d5).add(d6).add(d7).add(d8).add(d9).add(d10).add(d11).add(d12).add(d13).add(d14).add(d15).add(d16).add(d17).add(d18);


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
        Circuit518 generator = new Circuit518("Circuit518");
        generator.generateCircuit();
        generator.evalCircuit();
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));
        generator.prepFiles();
		//generator.runLibsnark();
	}

}
