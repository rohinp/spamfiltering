package com.spamfilter.utility;

public class RemoveConjunctionArticles {




	public String getRelevantData(String given) {

		String[] word = (new Seperator()).wordSeperator(given);

		return wordProcessing(word);
	}

	private String wordProcessing(String[] word) {
		String info="";
		
		for(int i=0;i<word.length;i++)
		{
			if(isMatch(word, i))
			{
				info=info+word[i]+" ";
			}
		}
		return info;
	}

	private boolean isMatch(String[] word, int i) {
		return !word[i].matches(StopWord.getStopWords("regX"));
	}


}
