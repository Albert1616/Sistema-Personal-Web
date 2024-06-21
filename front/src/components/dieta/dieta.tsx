import React from 'react';
import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"; // Certifique-se de importar corretamente seus componentes de tabela
import { FaAppleAlt, FaBreadSlice, FaCarrot, FaFish, FaCheese, FaEgg, FaLeaf, FaHamburger, FaPizzaSlice, FaCookie } from 'react-icons/fa';

function Dieta() {
    return (
        <div>
            <Table>
                <TableCaption className='text-xl font-bold'>Dieta</TableCaption>
                <TableHeader>
                    <TableRow>
                       <TableHead></TableHead>
                        <TableHead>Alimento</TableHead>
                        <TableHead>Quantidade</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    <TableRow>
                        <TableCell><FaBreadSlice size={30}/></TableCell>
                        <TableCell>Pão integral</TableCell>
                        <TableCell>200g</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaAppleAlt size={30}/></TableCell>
                        <TableCell>Maçã</TableCell>
                        <TableCell>2 unidades</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaCarrot size={30}/></TableCell>
                        <TableCell>Cenoura</TableCell>
                        <TableCell>150g</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaFish size={30}/></TableCell>
                        <TableCell>Peixe</TableCell>
                        <TableCell>150g</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaCheese size={30}/></TableCell>
                        <TableCell>Queijo</TableCell>
                        <TableCell>50g</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaEgg size={30}/></TableCell>
                        <TableCell>Ovo</TableCell>
                        <TableCell>2 unidades</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaLeaf size={30}/></TableCell>
                        <TableCell>Alface</TableCell>
                        <TableCell>100g</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaHamburger size={30}/></TableCell>
                        <TableCell>Hambúrguer</TableCell>
                        <TableCell>1 unidade</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaPizzaSlice size={30}/></TableCell>
                        <TableCell>Pizza</TableCell>
                        <TableCell>1 fatia</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell><FaCookie size={30}/></TableCell>
                        <TableCell>Biscoito</TableCell>
                        <TableCell>3 unidades</TableCell>
                    </TableRow>
                </TableBody>
            </Table>
        </div>
    );
}

export default Dieta;
