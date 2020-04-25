package com.fm.app.services;

public interface SequenceGeneratorService {
	public int generateSequence(String seqName);
	public int getMaxSequenceNoForSequence(String seqName);
}
