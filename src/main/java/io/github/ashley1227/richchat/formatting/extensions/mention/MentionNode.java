package io.github.ashley1227.richchat.formatting.extensions.mention;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public class MentionNode extends Node {
	private BasedSequence openingMarker = BasedSequence.NULL;

	public MentionNode() {
	}

	public MentionNode(BasedSequence chars) {
		super(chars);
	}

	@Override
	public void getAstExtra(StringBuilder out) {
		segmentSpanChars(out, openingMarker, "marker");
	}

	@Override
	public BasedSequence[] getSegments() {
		return new BasedSequence[] { openingMarker };
	}

	public BasedSequence getOpeningMarker() {
		return openingMarker;
	}

	public void setOpeningMarker(BasedSequence openingMarker) {
		this.openingMarker = openingMarker;
	}
}
