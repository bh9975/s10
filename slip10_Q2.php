 <?php
                define('pi',3.14);
                interface shape
                {
                                 function calc_area($r,$h);
                                 function calc_vol($r,$h);
                }
               
                class sphere implements shape
                {
                                function calc_area($r,$r)
                                {
                                                return 4*pi*$r*$r;          
                                }

                                function calc_vol($r,$r)
                                {
                                                return (4/3)*pi*$r*$r*$r;
                                }
                }

                class cylinder implements shape
                {
                                function calc_area($r,$h)
                                {
                                                return 2*pi*$r*($r+$h);               
                                }

                                function calc_vol($r,$h)
                                {
                                                return pi*$r*$r*$h;
                                }
                }

                class cone implements shape
                {
                                function calc_area($r,$h)
                                {
                                                return 0.5*$r*$r*$h;     
                                }

                                function calc_vol($r,$h)
                                {
                                                return $r*$r*$r*$h;
                                }
                }

                $op=$_GET['op'];

                switch($op)
                {
                                case 1 : $r=$_GET['r'];
                                                                                $h=$_GET['h'];
                                                                                $ob=new cone();
                                                                                $a=$ob->calc_area($r,$h);
                                                                                $v=$ob->calc_vol($r,$h);
                                                                                echo "Area of cone is".$a."<br>Volume of Cone is".$v;
                                                                                break;

                                case 2 : $r=$_GET['r'];
                                                                                $h=$_GET['h'];
                                                                                $ob=new cylinder();
                                                                                $a=$ob->calc_area($r,$h);
                                                                                $v=$ob->calc_vol($r,$h);
                                                                                echo "Area of Cylinder is".$a."<br>Volume of Cylinder is".$v;
                                                                                break;
                                                                               
                                case 3 : $r=$_GET['r'];
                                                                                $ob=new sphere();
                                                                                $a=$ob->calc_area($r,$r);
                                                                                $v=$ob->calc_vol($r,$r);
                                                                                echo "Area of Sphere is".$a."<br>Volume of Sphere is".$v;   
                                                                                break;                  
                }
?>
