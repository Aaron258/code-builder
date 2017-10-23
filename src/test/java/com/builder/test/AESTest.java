package com.builder.test;

import com.builder.main.AESUtil;

public class AESTest {

    public static void main(String[] args) {
       String  result = "IlIF+lvXG9NJms8lgdG2bumvYjKNnm5xSo0aE00S2HSPsP3aMmNCdVe/lDCsuUwc8+6Nz7ZmO+jA" +
                "53F8pNNjmMNct1ULFMk22NSF4Hx01vS8VZ2bI6rRlW7hfIPJSIN6YBIQJTGmvL0hvHUS2pFrLrTH" +
                "gyO9qDp/8FP5iI0eaCWF/ErQaY65Jx/EsUxKxiwJsPjmg5sKd6Lpf8Sw9JsRlk6QVckEFQR4JSUA" +
                "VZRWqKoo3Bwo+qoAcN7iWWVUKGfaekjfaAafQ38Spq0jlhnXfYUWEqk9Ui64zLdyudJ+wwlA/ITw" +
                "17yebdb+GO3GsDpC6KPm9On7koAstCCv1ClxpdsDTHe2d9OHT/C8Np+8hD4hs0EbHG8XlVZdfs3u" +
                "iVKsAJUZn5lJ5FQ73XCY5al+++CLOsUaeGTSX4EG0sHnT2AWf3vMZ2ACtS3WJgjV60ClsbZ1DCkj" +
                "KirOkyBIcpDxJK1vYA6qS46xqOm/EejeAwaNZ51FXr9w2j8QV6KZYYONp0yqL2p4myqDqD6lVIJ+" +
                "ID1LubhpLEFDlXPvyAg3t4iJTlB3WnKOU/ja610QgNzuf1WV7d/LnQqyig6l4EnqtUQ0yQFgp9PW" +
                "Kz6wH4SKoHS7TXpQSiElbyXdqpAtBpyMluhBkDLWEIzlAWrJ/npgg5Eo8cCO3/dHqJcdBBb0Eyuw" +
                "Eedj3rIlKkA3nL02MbApx1Y7Z2VuiUpvZiVcPftYyWYxD+DvIMi6pRwuXYrDWs43TnwQxuVP8t7A" +
                "INmUWyxoRDTJAWCn09YrPrAfhIqgdA/vhf/IfSVMIBr/ADIHWhqdjqdbpqR38ozOnwtsdryc50g7" +
                "HEu3XQDtldt8A3uYnBRkUEDCI2/dD0VsT8ZGOzEgjFC4GjlafV0jCBP+huGgRjLaJ7hRdsPYv/+Z" +
                "sA0ZZ8x2gwrRji1vlvuwRUjjARNhteC65qjSRuW8xoW2SrO0eKJMuF7LWW38vIj153zGXn3vqb3o" +
                "hrk0LP+F7qbyx4xHJpd3GGjLw/nLcuGBfPWY7rxZQ4YnboiO7ekDzoTHbwZrkEzTLw23cns+8508" +
                "8n+Spguy//7WgZPaZW8lhD0/DYwRKFvGQCtlFGLSSc/4+Lhcor3HISJNjje81QDlAL59GPIp9B8I" +
                "XpqsCrEm9SMqaLrW/GnbupCP4PBn/F/FZzS4RN8BsOjY5RKzLViLJyc1qUIRlW0sdT5SdbeWgw5D" +
                "nUQ+DxTUrfqnSe/1Aor3BQaMxrrvxoLpcpAgRCksUa2Nqi2mvsidihRJBQOcPOinpFJLxBkFCdTc" +
                "rs85wXiymcBRSmv0wMO5ooXTwnFsQfuECeR3VYw5ZkhjbObCRo62dlX2QEB6LVpDIvm0WQr3m+IK" +
                "uDPpmGsnLl66688dT8thoO4P0bNNR3nizftNZv2qpWYrKrmIi+6FDf2JVuTVG83+Awci7myoAiTX" +
                "qN7ldG3vTDzFqmaStFhjwaS2bJNpFFlmW+wEGg5efLOrCjhZ91YxvPsvWvmwgqTnJ81PTZ7D+Ake" +
                "qFEyP3nrNxS5CHV5e3Y2tgdYE+ZIoNSX6YSUeccw18Q/OYgHo/rxjjDSB0F+iYkVtNFCi4Iy50oS" +
                "VIBsbE70u5HT1WQHHb8lkjX/NOjQI/D6fTPtfrLADU2hv5xuX0vEVMj01rVyTlZKe5hqf80x0wpH" +
                "x8lEj4G1d8+53Y6KhekkAtdD+lQAFL2yUsMmQRG+lQVmWpA54UC6hw+AuWwh/zLVkprDZAuhJhnK" +
                "wq8cLEi8rvY/WOfVi0/u7jrvSndfhkJvZXKgwcNyCVU7xuhzN1BsAcxwWzfirm1EZtcPSiageDO7" +
                "Jtj63Z68M/LvA37Py4OqYymlVLC2/Cuen6x2hg5/RAzn7d0gel0+MEbo2Vv47QQs8vOkIHgDWSv6" +
                "TbIxOTJxOw1QRFrcCdjOzC5zJTfwIkTDI5aH+xQYtly1Vc+sj+spHe+YQCUHRDZ9A47nZdlfsDuG" +
                "qFsaMXrWlZ3mYEEv0peUddbQ1s4MARbEGMsVq+i793q8cGKPpWDoq9vWoaKewI7i536TI68JDtg+" +
                "8lbNBE6CEb9km8lo88wucyU38CJEwyOWh/sUGLZrXj1C4G1yQyFsCZMdDhVwajOMw4ncrjym5HOs" +
                "XERVdJWd5mBBL9KXlHXW0NbODAH31Zrn+twHaG2gQIU95A25LGh8bp9+DZ/NuAytsK01s7SemSFZ" +
                "ad7Gj+U1dLpNL15NF1GafMIzKbwQrXncDeE3kguM/GHDsMGL6AEKLf0KMYu4PYsRa8Scth8IGZkC" +
                "ImrYIoXCosBEAgQn7BFQ6CjnnuUQ02NMmfBMZrtbgcAgW+h/JSolRjfHJRHAvOyw9edVrpSPuGiW" +
                "4FsdycrIJFXWH1lFx2qXCuEfNlt5iGdXPPL/SgvUuJFF5QUCgd5LmxCfre+HDjVhs4hqlNwEi9lX" +
                "KjD52RO+Kpjj57WJnB79zcNalhGhIymUzUvTGyvCY5RZ+FSd8B/HKwwW/FeoYmibn/HQi2AsZQcd" +
                "L0dur9lxFFa9znFnRdfef8ze8bnOEi1Qd4X4ctdMU3ti1TayZd7WF45HsSJmhW7xp1HsWFnUQSpL" +
                "osFcGJNzpP1j4grp+eWCk0jN5n7a0+1n8wR3zmn0RE3A4XZ9egjfG+eECtiSDSSCVu+KSkAdr7Ge" +
                "01Q5jH5y6XlgsAb9gtjTIc+q83u9Xq1RbWEBejXhseydRvlry16tUW1hAXo14bHsnUb5a8us9AyM" +
                "2/O8yfcPKmSwJiU6RpPHuAcJyiTG+3NQSjCHwRLl7YEcD/AHJqINVFcuzVL0UbgWjbilP7iPxjBV" +
                "cNchHei+to70KUPhKhfBVl+OfJtx6gFn2S/Q9xLwgAQODsR0Fmso1etqQo09hPKipu6nYe5H0jgd" +
                "0a+6q+z1gZF1n+TmQiAtcQAiBle3QezKdTv/bJdTCQrBY7f71OkwLA3f+qBhCMNSvTU9lWKVAtCy" +
                "LVMS37vrBKvfU3rFCYdK2tbdWfwbwgcn7ZtXLaCRF7SFgCnHqay49PvUuLUMppv+Gi4gBvvd8DTg" +
                "3LM1TTFRBtQxc9BdUn976hyAbtM/7RVifW6hGQQJrXZV+lN0GAFyWgrdE0C8tpA5z4U0Ww3z9GR0" +
                "NUc9ZTd+EUqROpSlfdAO0sXhAhTK9PszGyHx+RfKycY0LawG9mBfyZpF2DGLTCe+o+jh3wMYPi5G" +
                "+YIjc9NJikulwMCs8Xncc5ZRbJUrJoH4rGQ636MnHXSZcndpsZ4OnYK5y2bY4x+WEs1DxvoEoLOz" +
                "EFdQHPdI8BFxNJu7528Q8dxT7if7V/p2dDZd8Ezhhd22sd18ws18bP8ERMpn7PxrGurdDRk15Gpa" +
                "q+ftHn62+w+5kdZyOamn2YkN5+rPX5/uSk7hRli9PO4SwbOo1Y9uhvlMgYRtmnT6l9/Ea+aVHlw5" +
                "ylH4M/kCiQnBR00EJJhYfWljfGEO8Ruj9kRhBzU8JSIMjX5tDJHmgP3dKinsh86YY2R0g22i7bYX" +
                "1CnUe3zAI3pzFL//uOBxOv8LMYOQ1tFYsM1YIOg6AkDaA2Vo+Taj9q/FXIivwb0YCfWhScYjQOiG" +
                "us2/nWR87JqeALGzkWHbDOJScWHr/AqD8gVr6oL2/utXnVX1uKCo8bj5zG6WH/6c8HxMntNNa4m2" +
                "tHO8RjCzC6ekQ2ffZ46f+mjmahTpJiv2jTepdBOUCM6tjSI+MkMnnL8HI/vYXzncaq/4H6nyWeoH" +
                "NNRmO7zeihURH9Jv7QxDqmn4Fdab4TqIFNgQnR7QQCTgCypXGfRmWgbsXY1naUObTSPl/BKV+94H" +
                "jbWyO28J7jBLJR8WZeb95c6ermK1eHo83CY6QlxBoGFHi2nuhs7FpiGdOWhVEGbi7pTUi9qmceLf" +
                "/OvMfy9K6KoDkFtNkSho7h+AEihvXTk+U7e2EgG7aIN0KAaXxwFgXbiBe3b985GbV5JbQtIqgoxk" +
                "VnV9COgMag6vzMkjrV9afo3XJZ0wBSbL97Dnyw==";
        System.out.println(AESUtil.AESDncode("49b2288c61514a3727731ea3e1be7872",result));
    }
}
