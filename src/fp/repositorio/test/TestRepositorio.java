package fp.repositorio.test;

import fp.repositorio.Repositorio;

public class TestRepositorio {

	public static void main(String[] args) {
		Repositorio repositorio = new Repositorio("freeCodeCamp,freeCodeCamp,The https://freeCodeCamp.com open source codebase and curriculum. Learn to code and help nonprofits.,2017-06-24 15:56:17,,290k,\"nonprofits,certification,curriculum,react,nodejs,javascript,d3,teachers,community,education,programming,math,learn-to-code,careers\",https://github.com/freeCodeCamp/freeCodeCamp");
		System.out.print(repositorio.getLanguage());
		
	}

}
