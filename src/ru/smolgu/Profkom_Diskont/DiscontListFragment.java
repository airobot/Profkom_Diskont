package ru.smolgu.Profkom_Diskont;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

public class DiscontListFragment extends Fragment implements OnItemClickListener {
	// Массив названий скидок
	String[] names = { "Принцип компани", "Чао Италия", "Печки-лавочки",
			"Элитсан", "Центрифуга", "Ле Бобо кафе", "GOLD", "Circus", "Тотем",
			"Птичка", "Зооцентр", "Эрудит", "The Best", "LADA Market",
			"Publica", "Машенька", "Полет", "Gross Haus", "Регион-тур",
			"SHOW TIME", "ГИНЕКОЛОГиЯ", "Много Цветов", "Фото Порт", "Легион",
			"Букет", "BRIDGE", "Арсенал Декор", "Atlantic", "Союз-тур",
			"1LIMO", "SILVER CINEMA", "АНТЕЛЬ", "МНОГО МЕТРОВ", "ДОДО пицца",
			"АэроБум", "АэроБум" };

	// Массив описания скидок
	String[] desc = {
			// 1
			"<text-align: justify><b>Скидка: 3%</b>\nАдрес:пр-т Гагарина, д.5\nтел:35-61-66,\nул.Кирова, д.30\nтел:64-31-50</text>",
			"<b>Скидка: 10%</b>\nАдрес:ул.Николаева, д.30\nтел:67-67-76\nсайт: chaoitalia.ru",
			"<b>Скидка: 10% на блюда Русской,\nЯпонской кухни (Кроме бара)</b>\nАдрес:ул. Октябрьской революции, д.9\nтел:64-39-17",
			"<b>Скидка: 15%</b>\nАдрес:пр-т. Гагарина, д.10/2;\nТБЦ Гамаюн, 3 этаж\nтел:32-88-63\nул. Рыленкова, д.40 ТБЦ Кривич\nтел:61-32-63\nvk.com/club42152506",
			"<b>Скидка: 3% на боулинг и кафе</b>\nАдрес:ул.Николаева, д.74\nтел:66-44-55\n66-22-56\nсайт: cen3fuga.ru",
			// 2
			"<b>Скидка: 10%</b>\nАдрес:ул.Николаева, д.30\nтел:67-67-76\nсайт: chaoitalia.ru",
			"<b>Скидка: 10%</b>\nАдрес:ул. Багратиона д.4\nтел:66-38-71\nvk.com/beerpublica",
			"<b>Скидка: 10% на бар</b>\nАдрес:ул.Николаева д.30\nтел:67-67-76\nсайт: chaoitalia.ru",
			"<b>Скидка: 10%</b>\nАдрес:ул.Крупской, д.43\nТЦ Европа, 3 этаж\nтел:69-11-69\nсайт: ",
			"<text-align: justify><b>Скидка: 7% на подарки</b>\nАдрес:г.Смоленск, ул.Б.Советская. д.22\nг.Смоленск, ул. Крупской, д.41А\nТорговый центр Белые ночи - 2-й этаж\nТел.: +7 (4812) 33-00-78\nТел./Факс: +7 (4812) 35-32-14\nwww.totem-shop.ru</text>",
			// 3
			"<b>Скидка: 5%</b>\nАдрес:ул.Большая Советская, д.12/1\nул.Дзержинского, д.2а\nтел:63-12-22\nул.Кирова, 2/57\nтел:63-06-22\nfotoptichka.ru",
			"<b>Скидка: 10% на все, кроме кормов</b>\nАдрес:ул. Кирова, д.48б\nтел:31-34-78\nул.Попова, д.20а.\nтел:31-05-15\nул.Рыленкова, д.40\nтел:59-44-66\nКруглосуточная ветеринарная помощь - 63-52-00",
			"<b>Скидка: 5%</b>\nАдрес:ул.Кирова д.36\nтел:65-65-13\nул.Колхозная площадь, д.6\nтел:27-28-29\nул.Рыленкова, д.49а\nтел:32-34-17\nсайт: www.smolerudit.ru/",
			"<b>Скидка: 10%</b>\nАдрес:ул.Николаева, д.30\nтел:67-67-76\nchaoitalia.ru",
			"<b>Скидка: 7%</b>\nАдрес:ул.Шевченко, д.75",
			// 4
			"<b>Скидка: 10%</b>\nАдрес:ул.Румянцева, д.11\nтел:522-866\nул.Багратиона, д.10\nтел:65-49-35\nпр-т Гагарина, д.11\nтел:64-37-63\nmashenka.su",
			"<b>Скидка: 30% на фильмы\n5% на девайсы и PS3 игры\n(Кроме новинок за последний месяц)</b>\nАдрес:ул.Октябрьской революции, д.13\nтел:65-96-30\nvk.com/poletonline",
			"<b>Скидка: предъявителю дисконта выдается карта со скидкой</b>\nАдрес:ул.Багратиона, д.8\nтел:+7-915-653-95-40\nул.Николаева, д.25\nтел:38-94-95\nТЦ Галактика\nтел:+7-910-114-74-69\nТЦ Маяк(ул.Петра Алексеева, д.1)\nтел:+7-915-644-46-88",
			"<b>Скидка: 10%</b>\nАдрес:ул.Памфилова, д.5, офис601\nтел:40-32-51\nshowtime67.ru",
			"<b>Скидка: 7%</b>\nАдрес:ул.Твардовского, д.27\nтел:55-94-73\nсайт:www.mc-gynecology.ru",
			// 5
			"<b>Скидка: 10%</b>\nАдрес:ТЦ Галактика\nул.Большая Советская, д.14\nтел:407-247\nул.Нормандии Неман, д.1\nтел:407-947\nmnogo-cvetov.com/‎",
			"<b>Скидка: 20% печать\n15% широкоформатная печать\n15% фотокниги\n2% техника</b>\nАдрес:пр-т Гагарина, д.14/2\nтел:40-66-72\nfoto-port.ru",
			"<b>Скидка: 12% на пейнтбол\n15% на lasertag</b>\nтел:409-409\nтел:8-920-661-10-00\nlasertag67.ru\nsmolpaintball.com",
			"<b>Скидка: 10%</b>\nАдрес:ул.Пржевальского, д.2\nтел:38-87-42",
			"<b>Скидка: 10% на раков</b>\nАдрес:ул.2ая Краснинская, д.7/1\nтел:408-152\nvk.com/club55797878",
			// 6
			"<b>Скидка: 10%\nИзделия ручной работы.\nОригинальные подарки и сувениры</b>\nАдрес:ул.Пржевальского, д.6/25\nтел:33-04-86\nra-arsenal.ru\nvk.com/arsenal_svadba",
			"<b>Скидка: 5%</b>\nАдрес:ул.Николаева, д.47\nтел:8-952-534-48-42",
			"<b>Скидка: от 2 до 8%</b>\nСтадион Спартак\nтел:65-13-85\n35-16-56\nsouztour@inbox.ru",
			"<b>Скидка: 10% на услуги лимузинов</b>\nтел:8-915-646-33-33\n1limo.ru",
			"<b>Скидка: 20% (на фильмы без меморандума)</b>\nАдрес:ул.Новомосковская, д.2/8\nТРК Галактика\nтел:30-47-17\n30-24-03\nсайт: www.silvercinema.ru/smolensk/",
			// 7
			"<b>Скидка: 10% на безкаркасную мебель\n5% на корпусную мебель\n50% на установку\nбесплатная доставка по городу</b>\nadmin@antel-mebel.ru\nvk.com/antelmabel\nantel-mebel.ru\nтел:84812-33-08-39",
			"<b>Скидка: Бесплатное юридическое оформление</b>\nАдрес:ул.Глинки, д.7\nтел:40-18-15\nmnogo-metrov.ru",
			"<b>Скидка: При заказе большой пиццы\nпепси 0,6л в подарок\nнужно назвать промо-код:212121</b>\nАдрес:пр.Строителей, д.22а\nтел:8-800-333-00-60\nсайт:dodopizza.ru",
			"<b>Скидка: 10% при заказе букетов\nиз воздушных шаров,\n5% на остальные услуги и\nтовары для праздников</b>\nАдрес:ул.Городок коминтерна, д.12а\nтел:40-70-80\naeroboom.ru",
			"<b>Скидка: 30% Первый месяц\n10% все последующие\nA-GYM - это новый зал единоборств\nСпециализация - миксфайт(ММА)\nбразильское джиу-джитцу(BJJ)\nЯвляется базой для тренировок\nкоманды Стрела-ALLIANCE Смоленск</b>\nАдрес:ул.Матросова, д.12\nтел:54-24-25\nvk.com/bjj67",
			// 8
			"<b>Скидка: 3% при предъявлении студенческого билета</b>\neurotorg.info" };

	// Массив номеров телефонов
	String[] tel = {
			// 1
			"356-166", "67-65-78", "64-39-17", "32-88-17", "66-44-55",
			// 2
			"67-67-76", "66-38-71", "67-67-76", "69-11-69", "33-00-78",
			// 3
			"63-12-22", "31-34-78", "65-65-13", "67-67-76", "",
			// 4
			"522866", "65-96-30", "38-94-95", "40-32-51", "55-94-73",
			// 5
			"407-247", "40-66-72", "409-409", "38-87-42", "408-152",
			// 6
			"33-04-86", "8-952-534-48-42", "65-13-85", "8-915-646-33-33",
			"30-47-17",
			// 7
			"33-08-39", "40-18-15", "8-800-333-00-60", "40-70-80", "54-24-25",
			// 8
			"" };

	// Массив Сайтов
	String[] site = {
			// 1
			"http://principcomp.ru",
			"http://chaoitalia.ru",
			"",
			"http://vk.com/club42152506",
			"http://cen3fuga.ru",
			// 2
			"http://chaoitalia.ru",
			"http://vk.com/beerpublica",
			"http://chaoitalia.ru",
			"http://www.cafecircus.ru/",
			"http://totem-shop.ru",
			// 3
			"http://fotoptichka.ru",
			"",
			"http://www.smolerudit.ru/",
			"http://chaoitalia.ru",
			"",
			// 4
			"http://mashenka.su", "http://vk.com/poletonline",
			"",
			"http://showtime67.ru/",
			"http://www.mc-gynecology.ru/",
			// 5
			"http://www.mnogo-cvetov.com", "http://foto-port.ru",
			"http://www.smolpaintball.com", "",
			"http://vk.com/club55797878",
			// 6
			"http://vk.com/arsenal_svadba", "", "", "http://1limo.ru",
			"http://www.silvercinema.ru/smolensk/",
			// 7
			"http://antel-mebel.ru", "http://www.mnogo-metrov.ru",
			"http://dodopizza.ru", "http://aeroboom.ru", "http://vk.com/bjj67",
			// 8
			"http://www.eurotorg.info" };

	// Массив Картинок скидок
	int[] img = {
			// 1
			R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04, R.drawable.pic05, 
			// 2
			R.drawable.pic06, R.drawable.pic07, R.drawable.pic08, R.drawable.pic09,	R.drawable.pic10,
			// 3
			R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15,
			// 4
			R.drawable.pic16, R.drawable.pic17, R.drawable.pic18, R.drawable.pic19, R.drawable.pic20,
			// 5
			R.drawable.pic21, R.drawable.pic22, R.drawable.pic23, R.drawable.pic24, R.drawable.pic25,
			// 6
			R.drawable.pic26, R.drawable.pic27, R.drawable.pic28, R.drawable.pic29, R.drawable.pic30,
			// 7
			R.drawable.pic31, R.drawable.pic32, R.drawable.pic33, R.drawable.pic34, R.drawable.pic35,
			// 8
			R.drawable.pic36 };

	DiskontData[] diskontData;

	ArrayList<ListData> catalog = new ArrayList<ListData>();
	MainActivity Activity;

	public DiscontListFragment(MainActivity activity) {
		Activity = activity;

		diskontData = new DiskontData[36];
		// Принцип компани
		diskontData[0] = new DiskontData();
		diskontData[0].telnum = new ArrayList<String>() {
			{
				add("4(812)-35-61-66");
				add("4(812)-64-31-50");
			}
		};
		diskontData[0].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.776142, 32.048997));
				add(new LatLng(54.768682, 32.040348));
			}
		};
		// Чао Италия
		diskontData[1] = new DiskontData();
		diskontData[1].telnum = new ArrayList<String>() {
			{
				add("4(812)-67-67-76");
			}
		};
		diskontData[1].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.772278, 32.028839));
			}
		};
		// Печки лавочки
		diskontData[2] = new DiskontData();
		diskontData[2].telnum = new ArrayList<String>() {
			{
				add("4(812)-64-39-17");
			}
		};
		diskontData[2].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.775537, 32.044488));
			}
		};
		// Элитсан
		diskontData[3] = new DiskontData();
		diskontData[3].telnum = new ArrayList<String>() {
			{
				add("4(812)-32-88-63");
				add("4(812)-61-32-63");
			}
		};
		diskontData[3].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.775096, 32.045875));
				add(new LatLng(54.758907, 32.102404));
			}
		};
		// Центрифуга
		diskontData[4] = new DiskontData();
		diskontData[4].telnum = new ArrayList<String>() {
			{
				add("4(812)-66-44-55");
				add("4(812)-66-22-56");
			}
		};
		diskontData[4].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.768203, 32.007774));
			}
		};
		// Лебобо
		diskontData[5] = new DiskontData();
		diskontData[5].telnum = new ArrayList<String>() {
			{
				add("4(812)-67-67-76");
			}
		};
		diskontData[5].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.772278, 32.028839));
			}
		};
		// Паблика
		diskontData[6] = new DiskontData();
		diskontData[6].telnum = new ArrayList<String>() {
			{
				add("4(812)-66-38-71");
			}
		};
		diskontData[6].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.773195, 32.028978));
			}
		};
		// Голд
		diskontData[7] = new DiskontData();
		diskontData[7].telnum = new ArrayList<String>() {
			{
				add("4(812)-67-67-76");
			}
		};
		diskontData[7].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.772278, 32.028839));
			}
		};
		// Циркус
		diskontData[8] = new DiskontData();
		diskontData[8].telnum = new ArrayList<String>() {
			{
				add("4(812)-69-11-69");
			}
		};
		diskontData[8].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.766821, 32.06283));
			}
		};
		// Тотем
		diskontData[9] = new DiskontData();
		diskontData[9].telnum = new ArrayList<String>() {
			{
				add("4(812)-33-00-78");
				add("4(812)-35-32-14");
			}
		};
		diskontData[9].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.781975, 32.052528));
				add(new LatLng(54.76764, 32.062057));
			}
		};
		// Птичка
		diskontData[10] = new DiskontData();
		diskontData[10].telnum = new ArrayList<String>() {
			{
				add("4(812)-63-12-22");
				add("4(812)-63-06-22");
			}
		};
		diskontData[10].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.78423, 32.053295));
				add(new LatLng(54.778315, 32.048539));
				add(new LatLng(54.769932, 32.023699));
			}
		};
		// Зооветцентр
		diskontData[11] = new DiskontData();
		diskontData[11].telnum = new ArrayList<String>() {
			{
				add("4(812)-31-34-78");
				add("4(812)-63-52-00");
				add("4(812)-31-05-15");
				add("4(812)-59-44-66");
			}
		};
		diskontData[11].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.768008, 32.056719));
				add(new LatLng(54.773645, 32.085882));
				add(new LatLng(54.75877, 32.102445));
			}
		};
		// Эрудит
		diskontData[12] = new DiskontData();
		diskontData[12].telnum = new ArrayList<String>() {
			{
				add("4(812)-65-65-13");
				add("4(812)-32-34-17");
				add("4(812)-27-28-29");
			}
		};
		diskontData[12].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.769786, 32.044062));
				add(new LatLng(54.760758, 32.108882));
			}
		};
		// Бест
		diskontData[13] = new DiskontData();
		diskontData[13].telnum = new ArrayList<String>() {
			{
				add("4(812)-67-67-76");
			}
		};
		diskontData[13].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.772278, 32.028839));
			}
		};
		// ЛадаМаркет
		diskontData[14] = new DiskontData();
		diskontData[14].telnum = new ArrayList<String>() {
		};
		diskontData[14].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.778116, 32.080283));
			}
		};
		// Машенька
		diskontData[15] = new DiskontData();
		diskontData[15].telnum = new ArrayList<String>() {
			{
				add("4(812)-52-28-66");
				add("4(812)-64-37-63");
				add("4(812)-65-49-35");
			}
		};
		diskontData[15].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.770001, 32.075025));
				add(new LatLng(54.780124, 32.0233));
				add(new LatLng(54.774276, 32.047766));
			}
		};
		// Полет
		diskontData[16] = new DiskontData();
		diskontData[16].telnum = new ArrayList<String>() {
			{
				add("4(812)-65-96-30");
			}
		};
		diskontData[16].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.773035, 32.044156));
			}
		};
		// Грос Хаус
		diskontData[17] = new DiskontData();
		diskontData[17].telnum = new ArrayList<String>() {
			{
				add("+7-915-653-95-40");
				add("+7-915-644-46-88");
				add("4(812)-38-94-95");
				add("+7-910-114-74-69");
			}
		};
		diskontData[17].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.778417, 32.023746));
				add(new LatLng(54.772605, 32.035004));
				add(new LatLng(54.794898, 32.057078));
				add(new LatLng(54.762119, 32.101249));
			}
		};
		// Шоу тайм
		diskontData[18] = new DiskontData();
		diskontData[18].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-32-51");
			}
		};
		diskontData[18].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.771172, 32.053089));
			}
		};
		// Гинекология
		diskontData[19] = new DiskontData();
		diskontData[19].telnum = new ArrayList<String>() {
			{
				add("4(812)-55-94-73");
			}
		};
		diskontData[19].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.779127, 32.066372));
			}
		};

		// Много Цветов
		diskontData[20] = new DiskontData();
		diskontData[20].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-72-47");
				add("4(812)-40-79-47");
			}
		};
		diskontData[20].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.794898, 32.057078));
				add(new LatLng(54.783657, 32.053345));
			}
		};
		// Фотопорт
		diskontData[21] = new DiskontData();
		diskontData[21].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-94-09");
				add("+7-920-661-10-00");
			}
		};
		diskontData[21].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.772135, 32.04557));
			}
		};
		// Легион
		diskontData[22] = new DiskontData();
		diskontData[22].telnum = new ArrayList<String>() {
			{
				add("4(812)-38-87-42");
			}
		};
		diskontData[22].mapdiskont = new ArrayList<LatLng>() {
			{
			}
		};
		// Букет
		diskontData[23] = new DiskontData();
		diskontData[23].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-81-52");
			}
		};
		diskontData[23].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.784399, 32.048325));
			}
		};
		// Бридж кафе
		diskontData[24] = new DiskontData();
		diskontData[24].telnum = new ArrayList<String>() {
			{
				add("4(812)-33-04-86");
			}
		};
		diskontData[24].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.771941, 32.041774));
			}
		};
		// Арсенал декор
		diskontData[25] = new DiskontData();
		diskontData[25].telnum = new ArrayList<String>() {
			{
				add("+7-952-534-48-42");
			}
		};
		diskontData[25].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.784297, 32.043721));
			}
		};
		// Атлантик
		diskontData[26] = new DiskontData();
		diskontData[26].telnum = new ArrayList<String>() {
			{
				add("4(812)-65-13-85");
				add("4(812)-35-16-56");
			}
		};
		diskontData[26].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.771831, 32.03188));
			}
		};
		// Союз тур
		diskontData[27] = new DiskontData();
		diskontData[27].telnum = new ArrayList<String>() {
			{
				add("+7-915-646-33-33");
			}
		};
		diskontData[27].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.783082, 32.034262));
			}
		};
		// 1 Лимо
		diskontData[28] = new DiskontData();
		diskontData[28].telnum = new ArrayList<String>() {
			{
				add("4(812)-30-47-17");
				add("4(812)-30-24-03");
			}
		};
		diskontData[28].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.774762, 32.045757));
			}
		};
		// Сильвер синема
		diskontData[29] = new DiskontData();
		diskontData[29].telnum = new ArrayList<String>() {
			{
				add("4(812)-33-08-39");
			}
		};
		diskontData[29].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.794255, 32.055643));
			}
		};
		// Антель
		diskontData[30] = new DiskontData();
		diskontData[30].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-18-15");
			}
		};
		// Много Метров
		diskontData[31] = new DiskontData();
		diskontData[31].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-18-15");
			}
		};
		diskontData[31].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.780303, 32.049354));
			}
		};
		// ДоДо пицца
		diskontData[32] = new DiskontData();
		diskontData[32].telnum = new ArrayList<String>() {
			{
				add("8-800-333-00-60");
			}
		};
		diskontData[32].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.762643, 32.084286));
			}
		};
		// Аэробум
		diskontData[33] = new DiskontData();
		diskontData[33].telnum = new ArrayList<String>() {
			{
				add("4(812)-40-70-80");
			}
		};
		diskontData[33].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.775643, 32.031999));
			}
		};
		// A-GYM
		diskontData[34] = new DiskontData();
		diskontData[34].telnum = new ArrayList<String>() {
			{
				add("4(812)-54-24-25");
			}
		};
		diskontData[34].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.766632, 32.029496));
			}
		};
		// Евроторг
		diskontData[35] = new DiskontData();
		diskontData[35].telnum = new ArrayList<String>() {
			{
			}
		};
		diskontData[35].mapdiskont = new ArrayList<LatLng>() {
			{
				add(new LatLng(54.76866, 32.039241));
				add(new LatLng(54.767991, 32.084657));
				add(new LatLng(54.77083, 32.05008));
				add(new LatLng(54.768516, 32.004303));
				add(new LatLng(54.764123, 32.055314));
				add(new LatLng(54.769759, 32.022375));
				add(new LatLng(54.778173, 32.016123));
			}
		};
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Создаем массив объектов ListData и заполняем их данными
		catalog = new ArrayList<ListData>();
		for (int i = 1; i <= 36; i++) {
			catalog.add(new ListData(names[i - 1], 0, img[i - 1], desc[i - 1]));
		}

		// Создаем адаптер данных
		DiscontAdapter catAdapter;
		catAdapter = new DiscontAdapter(getActivity(), catalog);

		View rootView = inflater.inflate(R.layout.discont_list_fragment, container, false);
		
		ListView list = (ListView) rootView.findViewById(R.id.discont_list);
		list.setOnItemClickListener(this);
		list.setAdapter(catAdapter);
		
		list.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				Log.e("scroll", "Hello");
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				
			}
		});
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		int image;
		String text;
		DiskontData phone;
		String sites;

		image = img[position];
		text = desc[position];
		phone = diskontData[position];
		sites = site[position];

		Activity.ShowDiscontFragment(image, text, phone, sites);
	}
}