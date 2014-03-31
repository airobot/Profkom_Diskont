package ru.smolgu.Profkom_Diskont;

public class ListData {
	String title; // Название товара
	int price; // Цена товара
	int image; // Ссылка на изображение
	String discribe; // HTML описание товара

	ListData(String _title, int _price, int _image, String _discribe) {
		title = _title;
		price = _price;
		image = _image;
		discribe = _discribe;
	}
}