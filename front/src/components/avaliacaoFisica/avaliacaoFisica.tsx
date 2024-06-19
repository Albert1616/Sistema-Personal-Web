import React from 'react'

import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow,
  } from "@/components/ui/table"  
import { table } from 'console'

interface medidas{
    peso:number,
    altura:number,
    peito:number,
    bicepsDireito:number,
    bicepsEsquerdo:number,
    antebracoDireito:number,
    antebracoEsquerdo:number,
    cintura:number,
    dorsal:number,
    quadricepsDireito:number,
    quadricepsEsquerdo:number,
    panturrilhaDireito:number,
    panturrilhaEsquerdo:number,
}

function avaliacaoFisica({...props}:medidas) {
  return (
    <div className='pb-4'>
        <div className='flex gap-6'>
            <p>Matheus Albert da Silva Araújo</p>
            <p>Peso: {props.peso} KG</p>
            <p>Alura: {props.altura} CM</p>
        </div>
        <div>
        <Table>
                    <TableCaption>Avaliação física</TableCaption>
                    <TableHeader>
                        <TableRow>
                            <TableHead>Músculo</TableHead>
                            <TableHead>Medida (cm)</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        <TableRow>
                            <TableCell>Peito</TableCell>
                            <TableCell>{props.peito}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Bíceps Direito</TableCell>
                            <TableCell>{props.bicepsDireito}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Bíceps Esquerdo</TableCell>
                            <TableCell>{props.bicepsEsquerdo}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Antebraço Direito</TableCell>
                            <TableCell>{props.antebracoDireito}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Antebraço Esquerdo</TableCell>
                            <TableCell>{props.antebracoEsquerdo}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Cintura</TableCell>
                            <TableCell>{props.cintura}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Dorsal</TableCell>
                            <TableCell>{props.dorsal}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Quadríceps Direito</TableCell>
                            <TableCell>{props.quadricepsDireito}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Quadríceps Esquerdo</TableCell>
                            <TableCell>{props.quadricepsEsquerdo}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Panturrilha Direita</TableCell>
                            <TableCell>{props.panturrilhaDireito}</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Panturrilha Esquerda</TableCell>
                            <TableCell>{props.panturrilhaEsquerdo}</TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
    </div>
    </div>
  )
}

export default avaliacaoFisica