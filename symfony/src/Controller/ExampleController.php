<?php declare(strict_types=1);

namespace App\Controller;


use Symfony\Component\HttpFoundation\Response;

class ExampleController
{
    public function index(): Response
    {
        sleep(5);
        return new Response();
    }
}