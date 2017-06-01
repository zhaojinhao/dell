$(function(){
    function objInit(obj){
      //return $(obj).html('<option>请选择</option>');
    }
	var arrData={
		北京市:{
		    '北京戴尔大悦城专卖店(T023942)':'',
		    '北京顺源嘉华顺义鑫海韵通电器店(T018910)':'',
		    '北京鼎峰旭日戴尔专卖店(T007428)':'',
		    '戴尔电脑槐房万达高端店(T033241)':'',
		    '戴尔电脑石景山万达高端店(T032475)':'',
		    '戴尔电脑荟聚购物广场高端店(T032982)':'',
		    '盛科源科怀柔店(T006188)':'',
		    '戴尔电脑西单大悦城高端店(T033242)':''
		},
		大连市:{
		    '大连拓金长兴电子城店(T025503)':'','大连思维创新科技有限公司奥林匹克店(N0668)':''
		},
		南京市:{
		    '江苏五星电器有限公司南京新街口店(E0079)':'','南京和雍华海店(T013971)':'','南京苏宁新街口店(SN025001)':'','南京熙华世金鹰天地商场店(T032923)':'','南京卓品赛格1A01店(T029870)':''
		},
		苏州市:{
		    '江苏五星电器有限公司苏州石路店(E0083)':'','苏州悠然新区赛格dell店(T025612)':'','苏州众乐赛格DELL专卖店(T032573)':'','华乐新区赛格DELL家用店(T033133)':''
		},
		杭州市:{
			'杭州康烁颐高西溪数码广场店(T021353)':'',
			'杭州青派高新数码城a108店(E0006)':'',
			'水木华力杭州西溪数码港a101店(E0010)':'',
			'杭州新友邦商行(先力时高新店)(E0020)':'',
			'杭州先力时颐高旗舰广场店(E0306)':'',
			'杭州青派颐高数码广场1015-1017(E0641)':'',
			'先力时颐高数码广场店(T018900)':'',
			'水木华力东部数码城1a08店(T019910)':'',
			'杭州先力时百脑汇1D08店(T022428)':'',
			'杭州青派百脑汇1c06店(T025209)':'',
			'杭州青派百脑汇1b03店(T025210)':'',
			'杭州先力时颐高1035-1057店(T6192)':''
		},
		上海市:{
		    '上海苏宁浦东第一店(T031396)':'','上海永乐七宝店(T031123)':'','上海东韶365数码1A09-1(T031205)':'','上海智凝百二1A01铂金店(T032056)':'','上海森大松江戴尔旗舰店(T025411)':'','上海为达新大陆数码1A01室(T031206)':'','上海振鼎协信星光广场专卖店(T029087)':'','上海永乐沪闵店(YL021020)':'','上海为达五角场颐高a108店(T000090)':'','上海为达虹桥龙湖天街商场店(T032561)':'','上海问明万乐成商场店(T031246)':'','上海苏宁奉贤生活广场店(T029091)':''
		},
		长沙市:{
		    '长沙聚正国储家用铂金店（临AW）(S0430)':'','长沙市悦方IDMAIL戴尔家用商场店(T033097)':''
		},
		广州市:{
		    '戴尔专卖店天河140b店(T004596)':'','广州畅航计算机科技有限公司百脑汇1B13店(T031641)':'','广州畅航计算机科技有限公司百脑汇1b27店(T002230)':'','广州东方红天河电脑城182铂金店(T033208)':''
		},
	
		厦门市:{
		    '厦门百脑汇1b10店(T007901)':'','厦门百脑汇1A02店(S0021)':'','厦门百脑汇1f07a店(S0156)':'','厦门百脑汇1c07店(T028953)':''
		},
	
		深圳市:{
		    '深圳市宝安区海雅缤纷城五楼L529家用Shopping Mall店(T033011)':'','深圳市新华强h1b005店(T027900)':'','新华强H1B026(T019286)':'','深圳新华强h1b020(T8576)':'','益群电器连锁横岗店(T017780)':'','润能赛格4801店(T018252)':'','深圳市观澜电子市场店(T029921)':'','深圳新华强H1B040-H1B041(T032144)':'','深圳新华强H1C058-H1C059(T000661)':''
		},
		西安市:{
		    '思远北郊赛格铂金店(T033557)':'','西安点诺赛格b2104店(T7095)':'','轻舟赛格b2037店(T017670)':'','西安众诚伟业赛格a2080店(T001110)':'','同强赛格a2036、2037店(T018373)':'','众诚伟业赛格a2008店(T017669)':'','飞迅赛格b2098店(T017666)':'','飞迅赛格b2086店(T017667)':'','轻舟北郊赛格一店(T017504)':'','轻舟西部1b006店(T028932)':'','陕西思远赛格a2068店(T5738)':'','轻舟西部赛格3店-1b025(W0151)':'','同强百脑汇1d06店(T018051)':'','西安秦中百脑汇1C04专卖店(T013198)':'','西安国美分部电视塔店(T002715)':'','西安苏宁钟楼色谷店(T017869)':'','西安苏宁莲湖路店(SN029001)':'','国美西安分部金花店(GM029006)':'','西安苏宁金花店(T003367)':'','西安苏宁未央路店(SN029002)':'','国美西安分部西二环店(GM029010)':'','国美西安分部北大街店(GM029001)':''
		},
		武汉市:{
		    'A-武汉悦东科贸戴尔成就专卖店(T033029)':'','科技王振宇戴尔成就店(T012920)':'','国美武汉分部唐家墩店(GM027006)':'','武汉经开万达店(T015736)':'','武汉苏宁光谷店(SN027007)':'','武汉苏宁解放大道店(SN027001)':'','武汉工贸航空卖场(T010986)':'','众泰联达武汉广资1017店(T020741)':'','武汉盛日资讯1059店(AWH03)':'','荆州蓝星百脑汇1D03店(T021214)':'','蓝之星中心电脑城店(T026800)':''
		},
		成都市:{
		    '国美成都天府立交店(T022869)':'','成都苏宁双楠店(T022872)':'','成都苏宁春熙路店(SN028004)':'','成都苏宁万年场二店(SN028003)':'','成都苏宁西大街店(SN028001)':'','国美成都分部盐市口旗舰店(GM028014)':'','国美成都分部万年场店(GM028009)':'','成都苏宁广场店(T004620)':''
		}
	};
	$.each(arrData,function(pF){
      $('#selF').append('<option value='+pF+'>'+pF+'</option>');
    });
    $('#selF').change(function(){
      objInit('#selT');
      objInit('#selC');
      $('#selT').html('<option >请选择门店</option>');
      $.each(arrData,function(pF,pS){
        if($('#selF option:selected').text()==pF){
          $.each(pS,function(pT,pC){
            $('#selT').append('<option value='+pT+'>'+pT+'</option>');
          });
        }
      })
    });
});